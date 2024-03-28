package com.project.dietively.ui

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationBarView
import com.project.dietively.R
import com.project.dietively.adapter.FoodAdapter
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentHomeBinding
import com.project.dietively.databinding.LayoutAddFoodBinding
import com.project.dietively.roomdb.DailyData
import com.project.dietively.roomdb.FoodItem
import com.project.dietively.util.getCurrentDate
import com.project.dietively.util.getDateToString
import com.project.dietively.viewmodel.AppViewModel
import java.util.Date


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val foodList = MutableLiveData<List<FoodItem>>()

    private lateinit var alertDialog: AlertDialog

    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.date.text = getCurrentDate()

        observe()

        binding.navigation.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                Log.d(TAG, "onNavigationItemSelected: ${item}")
                when (item.toString()) {
                    "Diary" -> {
                        findNavController().navigate(R.id.homeFragment)
                    }

                    "Progress" -> {
                        findNavController().navigate(R.id.progressFragment)
                    }

                    "Tracking" -> {
                        findNavController().navigate(R.id.recipesFragment)
                    }

                    "Profile" -> {
                        findNavController().navigate(R.id.profileFragment)
                    }
                }
                return false
            }

        })

    }

    private fun observe() {
        viewModel.getFoodItem.observe(viewLifecycleOwner) {
            setFoodList(it)
        }

        foodList.observe(viewLifecycleOwner) {
            Log.d(TAG, "observe: $it")
            setRecycleView(it)
        }

        viewModel.getUserDailyData.observe(viewLifecycleOwner) { data ->
            if (data != null) {

                Log.d(TAG, "observe: $data")
                val list =
                    data.filter { getCurrentDate() == getDateToString(it.date.toLong()) && it.userId == AppPreferences.loginUuid }
                var calSum = 0f
                var proSum = 0f
                var carSum = 0f
                var fatSum = 0f
                list.forEach {
                    calSum += it.calories.toFloat() * it.addCount
                    proSum += it.protein.toFloat() * it.addCount
                    carSum += it.carbohydrates.toFloat() * it.addCount
                    fatSum += it.fat.toFloat() * it.addCount
                }
                binding.cal.text = "${"%.1f".format(calSum)}"
                binding.pro.text = "${"%.1f".format(proSum)}"
                binding.car.text = "${"%.1f".format(carSum)}"
                binding.fat.text = "${"%.1f".format(fatSum)}"
            }
        }

    }

    private fun setFoodList(list: List<FoodItem>) {
        Log.d(TAG, "setFoodList: $list")
        setFilter(list)
        binding.recyclerView1.adapter = adapter
        setRecycleView(list)
    }

    private fun setRecycleView(foodItems: List<FoodItem>) {
        adapter.updateData(foodItems)
        Log.d(TAG, "setRecycleView: $foodItems")
    }

    private var adapter = FoodAdapter(arrayListOf(), object : FoodAdapter.OnClickListener {
        override fun onClick(item: FoodItem) {
            Toast.makeText(requireContext(), "selcted on ${item.name}", Toast.LENGTH_SHORT)
                .show()
            showDialog(item)
        }
    })

    private fun setFilter(foodItems: List<FoodItem>) {
        val itemTypes = listOf("All") + foodItems.map { it.type }.distinct()
        Log.d(TAG, "SetFilter: $itemTypes")

        val adapter = ArrayAdapter(requireContext(), R.layout.layout_dropdown_item, itemTypes)
        binding.foodType.apply {
            setAdapter(adapter)
            isCursorVisible = false
            inputType = 0
            inputType = InputType.TYPE_NULL
        }
        binding.foodType.setText(binding.foodType.adapter.getItem(0).toString(), false)
        binding.foodType.setOnItemClickListener { _, _, position, _ ->
            Log.d(TAG, "SetFilter: ${itemTypes.get(position)}")
            if (itemTypes.get(position) == "All") {
                foodList.postValue(foodItems)
            } else {
                val filteredFood = foodItems.filter { it.type.contains(itemTypes.get(position)) }
                foodList.postValue(filteredFood)
            }

        }
        foodList.postValue(foodItems)
    }

    private fun showDialog(foodItem: FoodItem) {
        try {
            val quantity = MutableLiveData<Int>(1)
            val builder = AlertDialog.Builder(requireContext())
            val bindingAlert = LayoutAddFoodBinding.inflate(layoutInflater)
            builder.setView(bindingAlert.root)
            //builder.setCancelable(false)
            alertDialog = builder.create()
            quantity.observe(this) {
                bindingAlert.ticketCount.text = "$it"
            }
            bindingAlert.addTicket.setOnClickListener {
                quantity.postValue(quantity.value?.plus(1) ?: 1)
            }
            bindingAlert.removeTicket.setOnClickListener {
                if (quantity.value!! > 1) {
                    quantity.postValue(quantity.value?.minus(1) ?: 1)
                }

            }
            bindingAlert.addBtn.setOnClickListener {
                val averageCalories = calculateAverage(foodItem.calories)
                val averageProtein = calculateAverage(foodItem.protein)
                val averageCarbohydrates = calculateAverage(foodItem.carbohydrates)
                val averageFat = calculateAverage(foodItem.fat)
                quantity.value?.let { it1 ->
                    DailyData(
                        Date().time.toString(),
                        AppPreferences.loginUuid.toString(),
                        foodItem.name,
                            "$averageCalories",
                        "$averageProtein",
                        "$averageCarbohydrates",
                        "$averageFat",
                        it1
                    )
                }?.let { it2 ->
                    viewModel.insertUserData(
                        it2
                    )
                }
                alertDialog.dismiss()
            }
            bindingAlert.name.text = foodItem.name
            bindingAlert.calories.text = foodItem.calories
            bindingAlert.protein.text = foodItem.protein
            bindingAlert.carbohydrates.text = foodItem.carbohydrates
            bindingAlert.fat.text = foodItem.fat

            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            alertDialog.show()
        } catch (e: Exception) {
            Log.e(TAG, "showDialog: ${e.message.toString()}")
        }
    }

    private fun calculateAverage(range: String): Double {
        var r = 0f
        try {
            Log.d(TAG, "calculateAverage: $range")
            r = if (range.contains("mg", ignoreCase = true)){
                val value = range.removeSuffix("mg").trim().toFloat()
                val valueInGrams = value / 1000.0
                valueInGrams.toFloat()
            }else if (range.contains("kcal", ignoreCase = true)){
                val value = range.removeSuffix("kcal").trim().toFloat()
                kilocaloriesToGrams(value).toFloat()
            }else if (range.contains("g", ignoreCase = true)){
                val value = range.removeSuffix("g").trim().toFloat()
                value
            }else{
                val value = range.replace(Regex("[^0-9.]"), "").trim().toFloat()
                value
            }
        } catch (e: Exception) {
            Log.e(TAG, "showDialog: ${e.message.toString()}")
        }
        return r.toDouble()
    }

    fun kilocaloriesToGrams(kilocalories: Float): Double {
        return kilocalories / 4.0
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "HomeFragment"
    }

}

