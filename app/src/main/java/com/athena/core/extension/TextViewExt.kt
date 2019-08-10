package com.athena.core.extension

import android.os.Build
import android.text.Html
import android.widget.TextView

fun TextView.setHtmlText(html: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.text = Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
    } else {
        this.text = Html.fromHtml(html)
    }
}