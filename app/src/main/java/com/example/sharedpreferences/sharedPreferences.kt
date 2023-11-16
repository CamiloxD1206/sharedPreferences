package com.example.sharedpreferences

import android.app.Application

class SharedPreferences : Application() {
    companion object {
        lateinit var prefs: Pref
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Pref(applicationContext)
    }
}
