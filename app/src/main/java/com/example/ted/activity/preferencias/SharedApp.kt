package com.example.ted.activity.preferencias

import android.app.Application

class SharedApp: Application(){
    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}