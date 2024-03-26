package com.project.dietively.roomdb

import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val databaseDao: DatabaseDao
) {

    suspend fun insertUser(userProfile: UserProfile) {
        databaseDao.insertUser(userProfile)
    }

    suspend fun updateUser(userProfile: UserProfile) {
        databaseDao.updateUser(userProfile)
    }

    suspend fun deleteUser(userProfile: UserProfile) {
        databaseDao.deleteUser(userProfile)
    }

    val getUser = databaseDao.getUser()

    suspend fun insertUserData(data: DailyData) {
        databaseDao.insertUserDailyData(data)
    }

    suspend fun updateUserData(data: DailyData) {
        databaseDao.updateUserDailyData(data)
    }

    suspend fun deleteUserData(data: DailyData) {
        databaseDao.deleteUserDailyData(data)
    }

    val getUserDailyData = databaseDao.getUserDailyData()


    suspend fun insertFoodItem(data: FoodItem) {
        databaseDao.insertFoodItem(data)
    }

    suspend fun insertFoodItems(data: List<FoodItem>) {
        databaseDao.insertFoodItems(data)
    }

    suspend fun updateFoodItem(data: FoodItem) {
        databaseDao.updateFoodItem(data)
    }

    suspend fun deleteFoodItem(data: FoodItem) {
        databaseDao.deleteFoodItem(data)
    }

    val getFoodItem = databaseDao.getFoodItem()

    suspend fun insertMenstrualDays(data: MenstrualDays) {
        databaseDao.insertMenstrualDays(data)
    }

    val getMenstrualDays = databaseDao.getMenstrualDays()
}