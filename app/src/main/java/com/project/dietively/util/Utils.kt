package com.project.dietively.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.project.dietively.roomdb.BMIResult
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale


fun Window.hideSystemUI() {
    WindowCompat.setDecorFitsSystemWindows(this, false)
    WindowInsetsControllerCompat(this, this.decorView).let { controller ->
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}

fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val currentDate = Date()
    return sdf.format(currentDate)
}

fun getDateToString(timeMillis: Long): String {
    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val currentDate = Date(timeMillis)
    return sdf.format(currentDate)
}

@SuppressLint("SimpleDateFormat")
fun convertStringToDate(dateString: String): Date? {
    val format = SimpleDateFormat("dd/MM/yyyy")
    return format.parse(dateString)
}

@SuppressLint("SimpleDateFormat")
fun stringToDate(dateString: String): Date? {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return format.parse(dateString)
}

@SuppressLint("SimpleDateFormat")
fun addMonthsToDate(date: Date, months: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = date
    calendar.add(Calendar.MONTH, months)
    return calendar.time
}

@SuppressLint("SimpleDateFormat")
fun addYearsToDate(date: Date, years: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = date
    calendar.add(Calendar.YEAR, years)
    return calendar.time
}

fun addOneDay(dateString: String, dateFormat: String): String {
    val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
    val cal = Calendar.getInstance()
    cal.time = sdf.parse(dateString) ?: Date()

    // Get the current date
    val currentDate = Calendar.getInstance()

    // Check if adding one day exceeds the current date
    if (cal.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR) &&
        cal.get(Calendar.DAY_OF_YEAR) == currentDate.get(Calendar.DAY_OF_YEAR)
    ) {
        // If adding one day exceeds the current date, return the current date
        return sdf.format(cal.time)
    }

    // Adding one day
    cal.add(Calendar.DAY_OF_MONTH, 1)

    return sdf.format(cal.time)
}

fun subtractOneDay(dateString: String, dateFormat: String): String {
    val formatter = DateTimeFormatter.ofPattern(dateFormat)
    val date = LocalDate.parse(dateString, formatter)
    val previousDate = date.minusDays(1) // Subtracting one day
    return previousDate.format(formatter)
}

fun extractYearsFromString(input: String): List<Int> {
    val regex = Regex("""\b\d+(?=th|st|nd|rd)\b""")
    val matches = regex.findAll(input)
    val years = matches.map { it.value.toInt() }.toList()
    return years
}

fun extractNumbersFromList(input: List<String>): List<Int> {
    val numbers = mutableListOf<Int>()
    for (item in input) {
        val number = item.filter { it.isDigit() }.toIntOrNull()
        if (number != null) {
            numbers.add(number)
        }
    }
    return numbers
}

@SuppressLint("SimpleDateFormat")
fun convertDateToString(date: Date, format: String = "dd/MM/yyyy"): String {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    return dateFormat.format(date)
}

fun String.isValidEmail(): Boolean {
    val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    return emailRegex.matches(this)
}

fun hideKeyboard(view: View) {
    val inputMethodManager =
        view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun classifyDate(date: Date): String {
    val currentDate = Calendar.getInstance().apply { time = Date() }
    val givenDate = Calendar.getInstance().apply { time = date }

    // Check if year, month, and day of month are equal
    return when {
        currentDate.get(Calendar.YEAR) == givenDate.get(Calendar.YEAR) &&
                currentDate.get(Calendar.MONTH) == givenDate.get(Calendar.MONTH) &&
                currentDate.get(Calendar.DAY_OF_MONTH) == givenDate.get(Calendar.DAY_OF_MONTH) -> {
            "isToday"
        }

        currentDate.after(givenDate) -> {
            "is pastday"
        }

        else -> {
            "next coming date"
        }
    }
}

fun isEmailValid(email: String): Boolean {
    val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$")
    return emailRegex.matches(email)
}

fun calculateBMI(weight: Double, height: Double, gender: String, age: Int): BMIResult {
    // BMI formula: weight (kg) / (height (m) * height (m))
    var bmi = weight / (height * height)

    // Adjust BMI based on gender and age
    bmi += when (gender.lowercase(Locale.ROOT)) {
        "male" -> when {
            age < 18 -> -1 // Adjust BMI for males under 18
            age in 18..30 -> -0.5 // Adjust BMI for males between 18 and 30
            age in 31..50 -> 0.5 // Adjust BMI for males between 31 and 50
            else -> 1.0 // Adjust BMI for males above 50
        }

        "female" -> when {
            age < 18 -> -1 // Adjust BMI for females under 18
            age in 18..30 -> -0.5 // Adjust BMI for females between 18 and 30
            age in 31..50 -> 0.5 // Adjust BMI for females between 31 and 50
            else -> 1.0 // Adjust BMI for females above 50
        }

        else -> 0.0 // No adjustment for other genders
    }.toDouble()

    val formattedBMI = String.format("%.2f", bmi)
    bmi = formattedBMI.toDouble()
    // Determine BMI category
    val category = when {
        bmi < 18.5 -> "Underweight"
        bmi < 25 -> "Normal weight"
        bmi < 30 -> "Overweight"
        else -> "Obese"
    }

    return BMIResult(bmi, category)
}
