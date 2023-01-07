package com.zzu.afreecatv.ui.common

import android.webkit.URLUtil
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.zzu.afreecatv.R

@BindingAdapter("image")
fun ImageView.setImage(url: String?) {
    url?.let { load(getHttpsUrl(it)) { placeholder(R.drawable.ic_afreeca) } }
}

@BindingAdapter("userId", "broadNo")
fun WebView.loadBroad(userId: String, broadNo: String) {
    val url = "http://play.afreecatv.com/${userId}/${broadNo}/embed"
    loadUrl(url)
}

private fun getHttpsUrl(url: String): String {
    return if (URLUtil.isValidUrl(url)) url else "https:$url"
}