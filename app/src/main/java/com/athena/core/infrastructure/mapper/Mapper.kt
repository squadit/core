package com.athena.core.infrastructure.mapper

interface Mapper {

    fun <T> convertToObjectFromJson(json: String?, classOfT: Class<T>): T?

    fun convertToJsonFromObject(value: Any?): String?
}