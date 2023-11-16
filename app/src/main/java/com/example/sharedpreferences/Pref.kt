package com.example.sharedpreferences

import android.content.Context

class Pref(val context:Context) {
    val sharedName="MyDataBase"
    val sharedUserName="username"
    val sharedUserVip="vip"
    val storage=context.getSharedPreferences(sharedName,0)

    fun saveName(name:String){
        storage.edit().putString(sharedUserName,name).apply()

    }

    fun  saveVIP(vip:Boolean){
        storage.edit().putBoolean(sharedUserVip,vip).apply()
    }

    fun getName(): String {
        return storage.getString(sharedUserName, "") ?: ""
    }

    fun getVip(): Boolean {
        return storage.getBoolean(sharedUserVip, false)
    }


    fun wipe(){
        storage.edit().clear().apply()
    }

}