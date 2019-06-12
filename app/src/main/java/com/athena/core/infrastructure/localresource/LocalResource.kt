package com.athena.core.infrastructure.localresource

object LocalResource {
    private var resources: MutableMap<String, String> = mutableMapOf()

    fun get(key: BaseResource) = resources[key.getKey()]

    fun set(resources: MutableMap<String, String>) {
        this.resources = resources
    }
}