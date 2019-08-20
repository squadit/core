package com.athena.core.extension

import android.view.View
import android.view.animation.AnimationUtils

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

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.animate(animId: Int) {
    startAnimation(AnimationUtils.loadAnimation(context, animId))
}