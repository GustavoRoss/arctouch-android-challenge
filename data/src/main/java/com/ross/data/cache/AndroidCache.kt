package com.ross.data.cache

import android.content.Context
import android.content.SharedPreferences
import com.ross.domain.boundaries.storage.Cache
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class AndroidCache : Cache {
    companion object {

        private const val PREFS_NAME = "APP_PREFERENCES"

        lateinit var sharedPreferences: SharedPreferences
            private set

        fun init(context: Context) {
            sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }
    }

    private val moshi = Moshi.Builder().build()

    @Throws(Cache.NotFoundException::class)
    override fun <T> get(key: String, type: Type): T {
        val stringValue = sharedPreferences.getString(key, null) ?: throw Cache.NotFoundException()
        return moshi.adapter<T>(type).fromJson(stringValue) ?: throw Cache.NotFoundException()
    }

    override fun set(key: String, value: Any?) {
        if (value == null) {
            sharedPreferences.edit().remove(key).apply()
        } else {
            sharedPreferences.edit().putString(key, moshi.adapter(Any::class.java).toJson(value)).apply()
        }
    }

    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }

}