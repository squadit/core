package com.athena.core.extension

import android.content.res.Resources
import android.view.View

//region density

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Float.toDp(): Float = this / Resources.getSystem().displayMetrics.density

fun Float.toPx(): Float = this * Resources.getSystem().displayMetrics.density

//endregion

//region visibility

fun View.showIf(condition: () -> Boolean) {
    if (visibility != View.VISIBLE && condition()) {
        visibility = View.VISIBLE
    }
}

fun View.hideIf(condition: () -> Boolean) {
    if (visibility != View.INVISIBLE && condition()) {
        visibility = View.INVISIBLE
    }
}

fun View.goneIf(condition: () -> Boolean) {
    if (visibility != View.GONE && condition()) {
        visibility = View.GONE
    }
}

fun View.toggleVisibility() {
    if (visibility == View.VISIBLE) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
    }
}

//endregion