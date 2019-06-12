package com.athena.core.common.entity

data class LocalResourceModel(
    val version: String,
    val data: MutableMap<String, String>?
)
