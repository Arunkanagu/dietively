package com.project.dietively.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.dietively.roomdb.DailyData
import com.project.dietively.roomdb.DatabaseRepository
import com.project.dietively.roomdb.FoodItem
import com.project.dietively.roomdb.MenstrualDays
import com.project.dietively.roomdb.UserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val databaseRepository: DatabaseRepository
) : ViewModel() {

    val toastMsgStr = MutableLiveData<String>("")

    fun insertUser(userProfile: UserProfile) {
        viewModelScope.launch {
            databaseRepository.insertUser(userProfile)
        }
    }

    fun updateUser(userProfile: UserProfile) {
        viewModelScope.launch {
            databaseRepository.updateUser(userProfile)
        }
    }

    fun deleteUser(userProfile: UserProfile) {
        viewModelScope.launch {
            databaseRepository.deleteUser(userProfile)
        }
    }

    val getUser = databaseRepository.getUser

    fun insertUserData(data: DailyData) {
        viewModelScope.launch {
            databaseRepository.insertUserData(data)
        }
    }

    fun updateUserData(data: DailyData) {
        viewModelScope.launch {
            databaseRepository.updateUserData(data)
        }
    }

    fun deleteUserData(data: DailyData) {
        viewModelScope.launch {
            databaseRepository.deleteUserData(data)
        }
    }

    val getUserDailyData = databaseRepository.getUserDailyData

    fun insertFoodItem(data: FoodItem) {
        viewModelScope.launch {
            databaseRepository.insertFoodItem(data)
        }
    }

    fun insertFoodItems(data: List<FoodItem>) {
        viewModelScope.launch {
            databaseRepository.insertFoodItems(data)
        }
    }

    fun updateFoodItem(data: FoodItem) {
        viewModelScope.launch {
            databaseRepository.updateFoodItem(data)
        }
    }

    fun deleteFoodItem(data: FoodItem) {
        viewModelScope.launch {
            databaseRepository.deleteFoodItem(data)
        }
    }

    val getFoodItem = databaseRepository.getFoodItem


    fun insertMenstrualDays(data: MenstrualDays) {
        viewModelScope.launch {
            databaseRepository.insertMenstrualDays(data)
        }
    }

    val getMenstrualDays = databaseRepository.getMenstrualDays


}