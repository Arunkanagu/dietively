package com.project.dietively

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.ActivityMainBinding
import com.project.dietively.util.getFoodItemList
import com.project.dietively.util.hideSystemUI
import com.project.dietively.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: AppViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        window.hideSystemUI()
        navController =
            (supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment).navController

        if (AppPreferences.loginUuid.isNullOrEmpty()){
            navController.navigate(R.id.loginFragment)
        }else{
            navController.navigate(R.id.homeFragment)
        }

        observeDate()

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (navController.currentDestination?.label == "fragment_home" || navController.currentDestination?.label == "fragment_login") {
                    finish()
                } else {
                    navController.popBackStack()
                }

            }
        })
    }

    private fun observeDate() {
        viewModel.getUser.observe(this) {
            Log.d(TAG, "observeDate: getUser -> $it")
        }

        viewModel.getFoodItem.observe(this) {
            Log.d(TAG, "observeDate: getFoodItem -> $it")
            if (it.isEmpty()) {
                viewModel.insertFoodItems(getFoodItemList().filter { true })
            }
        }

        viewModel.toastMsgStr.observe(this) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        //hideKeyboard(this.binding.root)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}