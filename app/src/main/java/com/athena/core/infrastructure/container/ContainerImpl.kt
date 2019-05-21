package com.athena.core.infrastructure.container

class ContainerImpl : Container {

    private val data: MutableMap<String, Any?> = mutableMapOf()

    override fun put(key: String, value: Any?) {
        data[key] = value
    }

    override fun get(key: String): Any? = data[key]

    override fun getOrDefault(key: String, defaultValue: Any?): Any? = if (contains(key)) data[key] else defaultValue

    override fun remove(key: String) = data.remove(key)

    override fun contains(key: String): Boolean = data.contains(key)

    override fun clear() = data.clear()
}