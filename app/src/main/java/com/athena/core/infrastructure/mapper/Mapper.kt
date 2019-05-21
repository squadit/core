package com.athena.core.infrastructure.mapper

interface Mapper {

    fun <T> convertToObjectFromJson(json: String, classOfT: Class<T>): T?

    fun <T> convertToJsonFromObject(value: T, classOfT: Class<T>): String
}