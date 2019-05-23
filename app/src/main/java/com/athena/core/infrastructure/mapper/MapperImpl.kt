package com.athena.core.infrastructure.mapper

import com.google.gson.GsonBuilder

class MapperImpl : Mapper {

    private val gson = GsonBuilder().create()

    override fun <T> convertToObjectFromJson(json: String?, classOfT: Class<T>): T? = gson.fromJson(json, classOfT)

    override fun convertToJsonFromObject(value: Any?): String? = gson.toJson(value)
}