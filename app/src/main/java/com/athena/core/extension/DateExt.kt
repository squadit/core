package com.athena.core.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatDate(pattern: String = "dd/MM/yyyy"): String {
    val formatter = SimpleDateFormat(pattern, Locale.getDefault())
    return formatter.format(this)
}

fun String.formatDateFromString(
    parsePattern: String = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZ",
    formattedPattern: String = "dd/MM/yyyy"
): String {
    return try {
        val parseFormatter = SimpleDateFormat(parsePattern, Locale.getDefault())
        val parsedDate = parseFormatter.parse(this)
        val simpleFormatter = SimpleDateFormat(formattedPattern, Locale.getDefault())
        simpleFormatter.format(parsedDate)
    } catch (ex: Exception) {
        ""
    }
}