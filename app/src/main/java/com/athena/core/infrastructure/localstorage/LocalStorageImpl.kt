package com.athena.core.infrastructure.localstorage

import android.content.Context
import android.content.SharedPreferences
import com.athena.core.infrastructure.mapper.Mapper

class LocalStorageImpl : LocalStorage {

    private val sharedPreferences: SharedPreferences
    private val mapper: Mapper

    constructor(context: Context, mapper: Mapper) {
        sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        this.mapper = mapper
    }

    override fun storeInt(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    override fun storeFloat(key: String, value: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    override fun storeLong(key: String, value: Long) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    override fun storeBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    override fun storeString(key: String, value: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun storeObject(key: String, value: Any?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, mapper.convertToJsonFromObject(value))
        editor.apply()
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    override fun <T> getObject(key: String, classOfT: Class<T>): T? {
        val json = sharedPreferences.getString(key, null)
        return mapper.convertToObjectFromJson(json, classOfT)
    }

    override fun remove(key: String) {
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }

    override fun clear() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    override fun getAllKeys(): List<String> {
        val keys = mutableListOf<String>()
        for ((key) in sharedPreferences.all) {
            keys.add(key)
        }
        return keys
    }
}