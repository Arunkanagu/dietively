package com.project.dietively.commen

import android.content.Context
import android.content.SharedPreferences
import com.project.dietively.DietivelyApp

object AppPreferences {
    private const val NAME = "kiosk_browser_preferences"
    private lateinit var preferences: SharedPreferences

    private val LOGIN_EMAIL = Pair("login_email", null)
    private val TODAY_DATA = Pair("today_data", null)


    fun init(context: Context = DietivelyApp.instance) {
        preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }

    var loginEmail: String?
        get() = preferences.getString(LOGIN_EMAIL.first, null)
        set(value) = preferences.edit().putString(LOGIN_EMAIL.first, value).apply()
    var todayData: String?
        get() = preferences.getString(TODAY_DATA.first, null)
        set(value) = preferences.edit().putString(TODAY_DATA.first, value).apply()

}