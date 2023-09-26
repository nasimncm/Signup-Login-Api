package com.example.turegunew.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.turegunew.utils.Constant.PREFS_TOKEN_FILE
import com.example.turegunew.utils.Constant.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {

    private val prefs = context.getSharedPreferences(PREFS_TOKEN_FILE, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor
    private var sharedPref: SharedPreferences
    private val PREFS_NAME = "nasim"

    init {
        sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun clear() {
        editor.clear().apply()
    }

    fun saveToken(authToken: String?){
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, authToken)
        editor.apply()
    }

    fun getToken() : String? {
        return prefs.getString(USER_TOKEN, null)
    }
}