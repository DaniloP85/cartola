package com.br.cartola.ui

import android.os.Bundle
import android.view.View.GONE
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.br.cartola.R
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

                    getLigas(tokenezed)

                } catch (e: IndexOutOfBoundsException) {
                } catch (e: NullPointerException) {
                }
            }
        }
    }

    private fun getLigas(tokenezed: String) {
        viewModel.getTimesApi(tokenezed)
    }

}