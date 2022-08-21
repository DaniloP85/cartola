package com.br.cartola.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.br.cartola.R
import com.br.cartola.model.LigaModel
import com.br.cartola.model.TimesModel
import com.br.cartola.ui.viewmodel.TimesCartolaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val url =
        "https://minhaconta-v2.globo.com"

    private val viewModel: TimesCartolaViewModel by inject()
    lateinit var tokenezed: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cartola = this.getSharedPreferences("cartola", Context.MODE_PRIVATE)


        webview.settings.javaScriptEnabled = true
        webview.loadUrl(url)
        webview.webViewClient = object : WebViewClient() {
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

                    //TODO esse é o motivo de chamar tres vezes
                    menu()
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

    private fun getLigas(tokenezed: String) : TimesModel? {
        return viewModel.getTimesApi(tokenezed)
    }

}