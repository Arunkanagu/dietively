package com.project.dietively.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.project.dietively.commen.AppPreferences

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userProfile: UserProfile)

    @Update
    suspend fun updateUser(userProfile: UserProfile)

    @Delete
    suspend fun deleteUser(userProfile: UserProfile)

    @Query("SELECT * FROM user_profile")
    fun getUser(): LiveData<List<UserProfile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserDailyData(data: DailyData)

    @Update
    suspend fun updateUserDailyData(data: DailyData)

    @Delete
    suspend fun deleteUserDailyData(data: DailyData)

    @Query("SELECT * FROM daily_data")
    fun getUserDailyData(): LiveData<List<DailyData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodItem(data: FoodItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFoodItems(foodItems: List<FoodItem>)

    @Update
    suspend fun updateFoodItem(data: FoodItem)

    @Delete
    suspend fun deleteFoodItem(data: FoodItem)

    @Query("SELECT * FROM food_item")
    fun getFoodItem(): LiveData<List<FoodItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenstrualDays(data: MenstrualDays)
    @Query("SELECT * FROM menstrual_day_data")
    fun getMenstrualDays(): LiveData<List<MenstrualDays>>


}