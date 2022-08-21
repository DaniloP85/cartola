package com.br.cartola.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.br.cartola.R
import com.br.cartola.model.TimesModel
import com.br.cartola.ui.viewmodel.TimesCartolaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val myUrl =
        "https://minhaconta-v2.globo.com/#/"

    private val viewModel: TimesCartolaViewModel by inject()
    lateinit var tokenezed: String

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cartola = this.getSharedPreferences("cartola", Context.MODE_PRIVATE)


        webview.settings.javaScriptEnabled = true
        webview.loadUrl(myUrl)
        webview.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.e("T", url!!)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                try {
                    textview.text = "Page Loading Started ..."
                    val cookie = CookieManager.getInstance().getCookie(url)

                    val token = cookie.split(";").filter {
                        it.indexOf("GLBID=") != -1
                    }

                    tokenezed = token.let {
                        it[0].replace("GLBID=", "").trim()
                    }

                    val editor = cartola.edit()
                    editor.putString("token", tokenezed)
                    editor.apply()

                    //TODO getLigas(tokenezed) esse era o comportamento original do @Samuel

                    if (url?.contains("https://login.globo.com/login/") == true) {
                        menu()
                    }
                } catch (e: IndexOutOfBoundsException) {
                } catch (e: NullPointerException) {
                }
            }
        }

    }

    private fun menu(){
        val saudacaoPersistencia = this.getSharedPreferences("cartola", Context.MODE_PRIVATE)
        val token = saudacaoPersistencia.getString("token", "")

        if (token.toString().isNotBlank()) {
            val intent = Intent(this, TabActivity::class.java)
            startActivity(intent)
        }
    }
   //TODO: não chamei na largada, mas essa função faz a chamada na API
    private fun getLigas(tokenezed: String) : TimesModel? {
        return viewModel.getTimesApi(tokenezed)
    }

}