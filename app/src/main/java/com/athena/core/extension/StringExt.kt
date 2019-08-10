package com.athena.core.extension

import android.util.Patterns
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun String.isNumeric(): Boolean = matches("\\d+".toRegex())

fun String.isValidEmail(): Boolean = matches(Patterns.EMAIL_ADDRESS.toRegex())

fun String.equalsIgnoreCase(other: String) = this.toLowerCase().contentEquals(other.toLowerCase())

fun String.isValidJson(): Boolean {
    return try {
        JSONObject(this)
        true
    } catch (ex: JSONException) {
        try {
            JSONArray(this)
            true
        } catch (ex1: JSONException) {
            false
        }
    }
}