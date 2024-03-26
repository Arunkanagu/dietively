package com.project.dietively.ui

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.project.dietively.R
import com.project.dietively.adapter.DayFoodAdapter
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentProgressBinding
import com.project.dietively.roomdb.DailyData
import com.project.dietively.util.addOneDay
import com.project.dietively.util.getCurrentDate
import com.project.dietively.util.getDateToString
import com.project.dietively.util.subtractOneDay
import com.project.dietively.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()

    private var dailyData: List<DailyData> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        selectedDate= getCurrentDate()

        viewModel.getUserDailyData.observe(viewLifecycleOwner) { data ->
            dailyData = data
            processData()
        }

        binding.date.setOnClickListener { showDatePickerDialog() }
        binding.nextDate.setOnClickListener { processData(addOneDay(selectedDate, "dd-MM-yyyy")) }
        binding.backDate.setOnClickListener {
            processData(
                subtractOneDay(
                    selectedDate,
                    "dd-MM-yyyy"
                )
            )
        }
    }

    private fun setTodayList(list: List<DailyData>) {
        val adapter = DayFoodAdapter(list, object : DayFoodAdapter.OnClickListener {
            override fun onClick(item: DailyData) {
                viewModel.toastMsgStr.postValue(item.foodItemName)
                viewModel.deleteUserData(item)
            }
        })
        binding.todayList.adapter = adapter
    }

    // Generate sample pie chart data
    private fun generatePieEntries(
        calSum: Float = 0f,
        proSum: Float = 0f,
        carSum: Float = 0f,
        fatSum: Float = 0f
    ): ArrayList<PieEntry> {
        val totalSum = calSum + proSum + carSum + fatSum

        val entries: ArrayList<PieEntry> = ArrayList()
        if (totalSum != 0f) {
            entries.add(PieEntry((calSum / totalSum) * 100, getString(R.string.calorie)))
            entries.add(PieEntry((proSum / totalSum) * 100, getString(R.string.protein)))
            entries.add(PieEntry((carSum / totalSum) * 100, getString(R.string.carbohydrates)))
            entries.add(PieEntry((fatSum / totalSum) * 100, getString(R.string.fat)))
        }
        return entries
    }

    private fun processData(filteredDateStr: String = selectedDate) {
        selectedDate = filteredDateStr
        binding.date.text = filteredDateStr
        val list =
            dailyData.filter { filteredDateStr == getDateToString(it.date.toLong()) && it.userId == AppPreferences.loginEmail }

        var calSum = 0f
        var proSum = 0f
        var carSum = 0f
        var fatSum = 0f
        if (list.isEmpty()) {
            binding.emptyData.visibility = View.VISIBLE
            binding.todayList.visibility = View.GONE
            binding.pieChart.clear()
        } else {
            binding.todayList.visibility = View.VISIBLE
            binding.emptyData.visibility = View.GONE
            setTodayList(list)
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

            setChart(
                generatePieEntries(
                    calSum,
                    proSum,
                    carSum,
                    fatSum
                )
            )
        }
    }

    private fun setChart(generatePieEntries: ArrayList<PieEntry>) {

        val pieChart = binding.pieChart
        val dataSet = PieDataSet(generatePieEntries, "")
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
        val data = PieData(dataSet)
        pieChart.setData(data)
        pieChart.holeRadius = 30f
        pieChart.setCenterTextSize(12f)
        pieChart.transparentCircleRadius = 40f
        pieChart.setDrawEntryLabels(true)
        pieChart.description.isEnabled = false
        dataSet.valueTextSize = 14f
        dataSet.setDrawValues(true)
        pieChart.animateY(800)
    }


    private fun showDatePickerDialog(context: Context = requireContext()) {
        // Initialize a Calendar instance
        val calendar = Calendar.getInstance()

        // If maxDate is not provided, set it to the current date
        val maximumDate = System.currentTimeMillis()

        // Create a DatePickerDialog with current date as default
        val datePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                // When a date is selected, this function will be called
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(Calendar.YEAR, year)
                selectedCalendar.set(Calendar.MONTH, month)
                selectedCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                // Format the selected date
                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedCalendar.time)

                processData(formattedDate)

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Set the maximum date
        datePickerDialog.datePicker.maxDate = maximumDate

        // Show the DatePickerDialog
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "ProgressFragment"
        private var selectedDate: String = getCurrentDate()
    }

}