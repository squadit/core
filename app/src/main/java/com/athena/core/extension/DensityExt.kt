package com.athena.core.extension

import android.content.res.Resources
import android.util.TypedValue

fun Float.toDpFromPx(): Float = this / Resources.getSystem().displayMetrics.density

fun Float.toPxFromDp(): Float = this * Resources.getSystem().displayMetrics.density

fun Float.toDpFromValue(): Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

fun Int.toDpFromPx(): Float = this / Resources.getSystem().displayMetrics.density

fun Int.toPxFromDp(): Float = this * Resources.getSystem().displayMetrics.density

fun Int.toDpFromValue(): Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics)