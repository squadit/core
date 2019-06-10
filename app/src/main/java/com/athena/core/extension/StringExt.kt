package com.athena.core.extension

import android.util.Patterns

fun String.isNumeric(): Boolean = matches("\\d+".toRegex())

fun String.isValidEmail(): Boolean = matches(Patterns.EMAIL_ADDRESS.toRegex())

fun String.equalsIgnoreCase(other: String) = this.toLowerCase().contentEquals(other.toLowerCase())
