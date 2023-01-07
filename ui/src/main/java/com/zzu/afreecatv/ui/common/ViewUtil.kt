package com.zzu.afreecatv.ui.common

import android.annotation.SuppressLint
import android.util.Log
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.zzu.afreecatv.R
import com.zzu.afreecatv.domain.model.Broad

@BindingAdapter("image")
fun ImageView.setImage(url: String?) {
    url?.let { load(getHttpsUrl(it)) { placeholder(R.drawable.ic_afreeca) } }
}

@SuppressLint("SetJavaScriptEnabled")
@BindingAdapter("loadBroad")
fun WebView.loadBroad(broad: Broad?) {
    broad?.let {
        object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                clearHistory()
                clearCache(true)
                super.onPageFinished(view, url)
            }
        }.apply { webViewClient = this }

        with(settings) {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
            domStorageEnabled = true
            useWideViewPort = false
            userAgentString = "Web"
        }
        val url = "https://play.afreecatv.com/${it.userId}/${it.broadNo}/embed"

        loadUrl(url)
    }
}

private fun getHttpsUrl(url: String): String {
    return if (URLUtil.isValidUrl(url)) url else "https:$url"
}