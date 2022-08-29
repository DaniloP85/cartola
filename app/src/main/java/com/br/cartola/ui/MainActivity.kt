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
import com.br.cartola.ui.viewmodel.LigasCartolaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val myUrl =
        "https://minhaconta-v2.globo.com/#/"

    lateinit var tokenezed: String

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cartola = this.getSharedPreferences("cartola", Context.MODE_PRIVATE)
        val cookie = CookieManager.getInstance().getCookie(myUrl)

        val intent = Intent(this, TabActivity::class.java)

        if (menu()) {
            val intent = Intent(this, TabActivity::class.java)
            startActivity(intent)
        } else {

            if (!cookie.isNullOrEmpty()) {
                token(cookie)
                val editor = cartola.edit()
                editor.putString("token", tokenezed)
                editor.apply()

                // TODO test token before load (Flavio)

                startActivity(intent)
            } else {
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
                            token(cookie)

                            if (tokenezed.isNotEmpty() && url?.contains("https://login.globo.com/login/") == true) {
                                startActivity(intent)
                            }
                        } catch (e: IndexOutOfBoundsException) {
                        } catch (e: NullPointerException) {
                        }
                    }
                }
            }
        }
    }

    private fun token(cookie: String) {
        if(cookie.isNotBlank() && cookie.contains("GLBID=")) {
            val token = cookie.split(";").filter {
                it.indexOf("GLBID=") != -1
            }

            tokenezed = token.let {
                it[0].replace("GLBID=", "").trim()
            }
        } else {
            tokenezed = ""
        }
    }

    private fun menu(): Boolean {
        val saudacaoPersistencia = this.getSharedPreferences("cartola", Context.MODE_PRIVATE)
        val token = saudacaoPersistencia.getString("token", "")

        return token.toString().isNotBlank()
    }
}