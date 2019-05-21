package com.athena.core.infrastructure.mapper

import com.squareup.moshi.Moshi

class MapperImpl : Mapper {

    private val moshi = Moshi.Builder().build()

    override fun <T> convertToObjectFromJson(json: String, classOfT: Class<T>): T? = moshi.adapter<T>(classOfT).fromJson(json)

    override fun <T> convertToJsonFromObject(value: T, classOfT: Class<T>): String = moshi.adapter<T>(classOfT).toJson(value)
}