package com.athena.core.infrastructure.container

interface Container {

    fun put(key: String, value: Any?)

    fun get(key: String): Any?

    fun getOrDefault(key: String, defaultValue: Any?): Any?

    fun remove(key: String): Any?

    fun contains(key: String): Boolean

    fun clear()
}