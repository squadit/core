package com.athena.core.extension

import android.content.res.Resources
import android.util.TypedValue

fun Float.toDpFromPx(): Float = this / Resources.getSystem().displayMetrics.density

fun Float.toPxFromDp(): Float = this * Resources.getSystem().displayMetrics.density

fun Float.toDpFromValue(): Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)