package com.project.dietively

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.ActivitySplashBinding
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                Log.d("SplashActivity", "onFinish: ${AppPreferences.expDate}")
                if (AppPreferences.expDate.isNullOrEmpty()) {
                    val calendar = Calendar.getInstance()
                    calendar.add(Calendar.DAY_OF_YEAR, 7)
                    AppPreferences.expDate = "${calendar.timeInMillis}"
                } else {
                    val checkDate = isToday(AppPreferences.expDate.toString().toLong())
                    Log.i("SplashActivity", "onFinish: $checkDate")
                    if (checkDate) {
                        Toast.makeText(DietivelyApp.instance, "App was expired", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        val intent = Intent(this@SplashActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

            }
        }

    }

    private fun isToday(longDate: Long): Boolean {
        val today = LocalDate.now()
        val dateToCheck =
            Instant.ofEpochMilli(longDate).atZone(ZoneId.systemDefault()).toLocalDate()
        Log.d("SplashActivity", "isToday: ${dateToCheck.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}")
        return dateToCheck < today
    }

    override fun onResume() {
        super.onResume()
        timer.start()
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }
}