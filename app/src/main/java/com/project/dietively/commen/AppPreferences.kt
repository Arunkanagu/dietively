package com.project.dietively.commen

import android.content.Context
import android.content.SharedPreferences
import com.project.dietively.DietivelyApp

object AppPreferences {
    private const val NAME = "kiosk_browser_preferences"
    private lateinit var preferences: SharedPreferences

    private val LOGIN_UUID = Pair("login_uuid", null)
    private val TODAY_DATA = Pair("today_data", null)
    private val EXP_DATE = Pair("exp_date", null)


    fun init(context: Context = DietivelyApp.instance) {
        preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }

    var loginUuid: String?
        get() = preferences.getString(LOGIN_UUID.first, null)
        set(value) = preferences.edit().putString(LOGIN_UUID.first, value).apply()
    var todayData: String?
        get() = preferences.getString(TODAY_DATA.first, null)
        set(value) = preferences.edit().putString(TODAY_DATA.first, value).apply()

    var expDate: String?
        get() = preferences.getString(EXP_DATE.first, null)
        set(value) = preferences.edit().putString(EXP_DATE.first, value).apply()

}