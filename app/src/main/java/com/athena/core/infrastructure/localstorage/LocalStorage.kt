package com.athena.core.infrastructure.localstorage

interface LocalStorage {

    fun storeInt(key: String, value: Int)

    fun storeFloat(key: String, value: Float)

    fun storeLong(key: String, value: Long)

    fun storeBoolean(key: String, value: Boolean)

    fun storeString(key: String, value: String?)

    fun storeObject(key: String, value: Any?)

    fun getInt(key: String, defaultValue: Int): Int

    fun getFloat(key: String, defaultValue: Float): Float

    fun getLong(key: String, defaultValue: Long): Long

    fun getBoolean(key: String, defaultValue: Boolean): Boolean

    fun getString(key: String): String?

    fun <T> getObject(key: String, classOfT: Class<T>): T?

    fun remove(key: String)

    fun clear()

    fun getAllKeys(): List<String>
}