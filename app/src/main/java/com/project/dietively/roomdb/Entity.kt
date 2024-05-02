package com.project.dietively.roomdb

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.project.dietively.util.getCurrentDate
import java.util.Date

@Keep
@Entity(
    tableName = "user_profile",
    indices = [Index(value = ["email"], unique = true)]
)
data class UserProfile(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "user_id")
    var userId: String = "",
    var user: String = "",
    var email: String = "",
    var phone: String = "",
    @ColumnInfo(name = "date_of_birth")
    var dateOfBirth: String = "",
    var age: Int = 0,
    var genter: String = "",
    var password: String = "",
    var tracking: String = "",
    var trackingData: String = "",
    @ColumnInfo(name = "last_update")
    var lastUpdate: Long = Date().time
)

@Keep
@Entity(tableName = "food_item")
data class FoodItem(
    val name: String,
    val calories: String,
    val protein: String,
    val fat: String,
    val carbohydrates: String,
    val type: String,
    var img: Int = 0,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)

@Keep
@Entity(tableName = "daily_data")
data class DailyData(
    @PrimaryKey
    val date: String = getCurrentDate(),
    @ColumnInfo(name = "user_id")
    val userId: String,
    @ColumnInfo(name = "food_item_name")
    val foodItemName: String,
    val calories: String,
    val protein: String,
    val carbohydrates: String,
    val fat: String,
    @ColumnInfo(name = "add_count")
    val addCount: Int = 1
)

@Keep
@Entity(tableName = "menstrual_day_data")
data class MenstrualDays(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("user_id")
    var userId: String = "",
    @SerializedName("last_period_date")
    var lastPeriodStartDate: String = getCurrentDate(),
    @SerializedName("during_days")
    var duringDays: Int = 0,
    @SerializedName("usual_cycle_length")
    var usualCycleLength: Int = 0,
    @SerializedName("save_time")
    var saveTime: Long = Date().time
)

data class PeriodsData(
    var lastPeriodStratDate: String = getCurrentDate(),
    var duringDays: Int = 5,
    var cycleDays: Int = 20
)

data class WorkoutView(
    val textView: TextView,
    val imageViem: ImageView
)


data class CalendarDay(
    val dayOfMonth: Int,
    var isSelected: Boolean = false,
    @ColorRes
    var backgroundColor: Int = android.R.color.transparent
)

data class BMIResult(var bmi: Double = 0.0, var category: String = "")

data class Person(var weight: Double, var height: Double, var gender: String, var age: Int)
