package com.athena.core.infrastructure.localresource

object LocalResource {
    private var resources: MutableMap<String, String> = mutableMapOf()

    fun get(key: String) = resources[key] ?: ""

    fun set(resources: MutableMap<String, String>) {
        this.resources = resources
    }
}