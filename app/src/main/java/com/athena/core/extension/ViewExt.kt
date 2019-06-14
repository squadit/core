package com.athena.core.extension

import android.content.res.Resources
import android.util.TypedValue
import android.view.View

//region density

fun Float.toDpFromPx(): Float = this / Resources.getSystem().displayMetrics.density

fun Float.toPxFromDp(): Float = this * Resources.getSystem().displayMetrics.density

fun Float.toDpFromValue(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

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