package com.project.dietively.roomdb

import android.widget.ImageView
import android.widget.TextView
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

data class WorkoutView(
    val textView: TextView,
    val imageViem: ImageView
)