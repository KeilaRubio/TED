package com.example.ted.activity.preferencias

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    val PREFS_NAME = "com.example.ted.activity"
    val SHARED_NAME = "posicion_viewpager"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var positionView: String?
//        get() = prefs.getInt(SHARED_NAME,0)
        get() = prefs.getString(SHARED_NAME, "")

        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()
//    set(value) = prefs.edit().putInt(SHARED_NAME,0).apply()

}