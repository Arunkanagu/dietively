package com.project.dietively

import android.app.Application
import com.project.dietively.commen.AppPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DietivelyApp : Application() {
    companion object {
        lateinit var instance: DietivelyApp
            private set
        private const val TAG = "DietivelyApp"
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppPreferences.init(instance)
    }
}