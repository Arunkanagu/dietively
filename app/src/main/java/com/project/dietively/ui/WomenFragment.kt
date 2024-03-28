package com.project.dietively.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.project.dietively.R
import com.project.dietively.adapter.CalendarAdapter
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.DialogChangeDataBinding
import com.project.dietively.databinding.FragmentWomenBinding
import com.project.dietively.roomdb.CalendarDay
import com.project.dietively.roomdb.MenstrualDays
import com.project.dietively.roomdb.PeriodsData
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.util.getCurrentDate
import com.project.dietively.util.getDateToString
import com.project.dietively.util.stringToDate
import com.project.dietively.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class WomenFragment : Fragment() {

    private var _binding: FragmentWomenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()
    private var userData: UserProfile? = null

    private var year = 2024
    private var month = 3 // March
    private var dateOfMonth: List<CalendarDay> = listOf()
    private var periodDays: ArrayList<Long> = arrayListOf()
    private var prePeriod: ArrayList<Long> = arrayListOf()
    private var postPeriod: ArrayList<Long> = arrayListOf()
    private var peakOvulation: ArrayList<Long> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWomenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser.observe(viewLifecycleOwner) { u ->
            userData = u.find { it.userId == AppPreferences.loginUuid }!!
            if (userData != null) {
                Log.d(TAG, "onViewCreated: userData $userData")
                if (userData!!.trackingData.isNotEmpty()) {
                    val t = Gson().fromJson(
                        userData?.trackingData, PeriodsData::class.java
                    )

                    Log.d(TAG, "onViewCreated: json ${t}")
                    val date: Date = addDaysToDate(t.lastPeriodStratDate, t.cycleDays)

                    if (date.time < Date().time) {
                        val t2 = t
                        val temp = userData
                        t.lastPeriodStratDate = getDateToString(date.time)
                        t.duringDays = t2.duringDays
                        t.cycleDays = t2.cycleDays

                        Log.d(TAG, "onViewCreated: temp ")
                        if (temp != null) {
                            temp.trackingData = Gson().toJson(t)

                            Log.d(TAG, "onViewCreated: temp ${temp}")
                            viewModel.insertUser(temp)
                        }
                    }
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!binding.mainLayout.isVisible) {
                        setViewLayout()
                    } else {
                        findNavController().popBackStack(R.id.homeFragment, false)
                    }
                }
            })

        binding.back.setOnClickListener {
            if (!binding.mainLayout.isVisible) {
                setViewLayout()
            } else {
                findNavController().popBackStack(R.id.homeFragment, false)
            }
        }

        binding.changeDate.setOnClickListener {
            showCustomAlertDialog()
        }
        binding.resetDate.setOnClickListener {
            val temp = userData
            if (temp != null) {
                temp.trackingData = ""
                viewModel.insertUser(temp)
                setViewLayout("periods_track")
            }

        }

        setViewLayout()
        buttonAction()

    }

    private fun buttonAction() {
        with(binding) {
            healthCare.setOnClickListener {
                findNavController().navigate(R.id.menFragment)
            }
            periodsTrack.setOnClickListener {
                setViewLayout("periods_track")
            }
        }
    }

    private fun setViewLayout(layout: String = "main") {
        with(binding) {
            mainLayout.visibility = View.GONE
            formLayout.visibility = View.GONE
            periodsTrackLayout.visibility = View.GONE
            when (layout) {
                "main" -> {
                    mainLayout.visibility = View.VISIBLE
                }

                "periods_track" -> {
                    dateOfMonth = listOf()
                    periodDays = arrayListOf()
                    prePeriod = arrayListOf()
                    postPeriod = arrayListOf()
                    peakOvulation = arrayListOf()
                    if (userData?.trackingData.isNullOrEmpty()) {
                        formLayout.visibility = View.VISIBLE
                        periodsTrackViewSet()
                    } else {
                        periodsTrackLayout.visibility = View.VISIBLE
                        setTackingData(
                            Gson().fromJson(
                                userData?.trackingData, PeriodsData::class.java
                            )
                        )
                    }
                }

                else -> {}
            }
        }
    }

    private fun setTackingData(fromJson: PeriodsData) {
        binding.periodCalender.layoutManager = GridLayoutManager(requireContext(), 7)
        dateOfMonth = generateDaysForMonth(year, month)
        calculatePeriodDays(fromJson)

        binding.monthName.text = getMonthName(year, month)

        binding.backDate.setOnClickListener {
            setCalender(false)
        }
        binding.nextDate.setOnClickListener {
            setCalender(true)
        }
        val thisMonthPeriod = filterPeriodDaysByYearAndMonth(periodDays, year, month)
        val thisMonthPrePeriod = filterPeriodDaysByYearAndMonth(prePeriod, year, month)
        val thisMonthPostPeriod = filterPeriodDaysByYearAndMonth(postPeriod, year, month)
        val tempCal = Calendar.getInstance()

        dateOfMonth.forEach { c ->
            thisMonthPeriod.forEach {
                tempCal.timeInMillis = it
                if (tempCal.get(Calendar.DAY_OF_MONTH) == c.dayOfMonth) {
                    c.isSelected = true
                    c.backgroundColor = R.color.period_day
                }
            }
            thisMonthPrePeriod.forEach {
                tempCal.timeInMillis = it
                if (tempCal.get(Calendar.DAY_OF_MONTH) == c.dayOfMonth) {
                    c.isSelected = true
                    c.backgroundColor = R.color.pre_period
                }
            }
            thisMonthPostPeriod.forEach {
                tempCal.timeInMillis = it
                if (tempCal.get(Calendar.DAY_OF_MONTH) == c.dayOfMonth) {
                    c.isSelected = true
                    c.backgroundColor = R.color.post_period
                }
            }
        }
        binding.periodCalender.adapter = CalendarAdapter(dateOfMonth)
    }

    private fun calculatePeriodDays(fromJson: PeriodsData) {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val startDate = fromJson.lastPeriodStratDate
        val date = stringToDate(startDate)
        val calendar = Calendar.getInstance()
        if (date != null) {
            calendar.time = date
        }
        var repeat = 0
        while (repeat != periodsCalculateMonth) {
            periodDays.add(calendar.timeInMillis)
            calendar.add(Calendar.DAY_OF_MONTH, -1)
            prePeriod.add(calendar.timeInMillis)
            calendar.add(Calendar.DAY_OF_MONTH, -1)
            prePeriod.add(calendar.timeInMillis)
            calendar.add(Calendar.DAY_OF_MONTH, 2)
            for (i in 0..<fromJson.duringDays - 1) {
                calendar.add(Calendar.DAY_OF_MONTH, 1)
                //Log.d(TAG, "calculatePeriodDays: ${dateFormat.format(calendar.time)}")
                periodDays.add(calendar.timeInMillis)
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            postPeriod.add(calendar.timeInMillis)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            postPeriod.add(calendar.timeInMillis)
            calendar.add(Calendar.DAY_OF_MONTH, -2)
            calendar.add(Calendar.DAY_OF_MONTH, (fromJson.cycleDays - fromJson.duringDays) + 1)

            repeat += 1
        }
        Log.d(TAG, "calculatePeriodDays: ${fromJson}")
        periodDays.forEach {
            Log.d(TAG, "calculatePeriodDays: periodDays -> ${dateFormat.format(it)}")
        }
        prePeriod.forEach {
            Log.d(TAG, "calculatePeriodDays: prePeriod -> ${dateFormat.format(it)}")
        }
        postPeriod.forEach {
            Log.d(TAG, "calculatePeriodDays: postPeriod -> ${dateFormat.format(it)}")
        }
    }

    private fun filterPeriodDaysByYearAndMonth(
        periodList: ArrayList<Long>,
        year: Int,
        month: Int
    ): ArrayList<Long> {
        val filteredDays = ArrayList<Long>()

        for (dayInMillis in periodList) {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = dayInMillis

            val dayYear = calendar.get(Calendar.YEAR)
            val dayMonth = calendar.get(Calendar.MONTH) + 1 // Calendar.MONTH is zero-based

            if (dayYear == year && dayMonth == month) {
                filteredDays.add(dayInMillis)
            }
        }

        return filteredDays
    }

    private fun setCalender(b: Boolean) {
        val (newYear, newMonth) = addOrRemoveMonth(year, month, b)
        year = newYear
        month = newMonth
        binding.monthName.text = getMonthName(year, month)
        dateOfMonth = generateDaysForMonth(year, month)
        /*dateOfMonth.forEach {
            it.backgroundColor = R.color.app_green_100
            it.isSelected = true
        }*/
        val thisMonthPeriod = filterPeriodDaysByYearAndMonth(periodDays, year, month)
        val thisMonthPrePeriod = filterPeriodDaysByYearAndMonth(prePeriod, year, month)
        val thisMonthPostPeriod = filterPeriodDaysByYearAndMonth(postPeriod, year, month)

        val tempCal = Calendar.getInstance()
        dateOfMonth.forEach { c ->
            thisMonthPeriod.forEach {
                tempCal.timeInMillis = it
                if (tempCal.get(Calendar.DAY_OF_MONTH) == c.dayOfMonth) {
                    c.isSelected = true
                    c.backgroundColor = R.color.period_day
                }
            }
            thisMonthPrePeriod.forEach {
                tempCal.timeInMillis = it
                if (tempCal.get(Calendar.DAY_OF_MONTH) == c.dayOfMonth) {
                    c.isSelected = true
                    c.backgroundColor = R.color.pre_period
                }
            }
            thisMonthPostPeriod.forEach {
                tempCal.timeInMillis = it
                if (tempCal.get(Calendar.DAY_OF_MONTH) == c.dayOfMonth) {
                    c.isSelected = true
                    c.backgroundColor = R.color.post_period
                }
            }
        }
        binding.periodCalender.adapter = CalendarAdapter(dateOfMonth)
    }

    private fun addOrRemoveMonth(year: Int, month: Int, add: Boolean): Pair<Int, Int> {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month - 1) // Calendar months are 0-based

        if (add) {
            calendar.add(Calendar.MONTH, 1)
        } else {
            calendar.add(Calendar.MONTH, -1)
        }

        val newYear = calendar.get(Calendar.YEAR)
        val newMonth = calendar.get(Calendar.MONTH) + 1 // Adding 1 because months are 0-based

        return Pair(newYear, newMonth)
    }

    private fun getMonthName(year: Int, month: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month - 1)
        val dateFormat = SimpleDateFormat("MMMM, yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    private fun addDaysToDate(dateString: String, daysToAdd: Int): Date {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()
        val date: Date = dateFormat.parse(dateString) ?: Date()

        calendar.time = date
        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd)

        return calendar.time
    }

    private fun periodsTrackViewSet(data: PeriodsData = PeriodsData()) {
        with(binding) {
            var duringDaysTemp = data.duringDays
            var cycleDaysTemp = data.cycleDays
            lastPeriodStratDate.setText(data.lastPeriodStratDate)
            duringDays.setText("$duringDaysTemp")
            cycleDays.setText("$cycleDaysTemp")

            startTracking.setOnClickListener {
                try {
                    val saveData = PeriodsData(
                        lastPeriodStratDate.text.toString(), duringDaysTemp, cycleDaysTemp
                    )
                    Log.d(TAG, "periodsTrackViewSet: $saveData")
                    if (userData != null) {
                        userData?.trackingData = Gson().toJson(saveData)
                        viewModel.insertUser(userData!!)
                        setViewLayout("periods_track")
                        viewModel.insertMenstrualDays(
                            MenstrualDays(
                                userId = AppPreferences.loginUuid.toString(),
                                lastPeriodStartDate = saveData.lastPeriodStratDate,
                                duringDays = saveData.duringDays,
                                usualCycleLength = saveData.cycleDays
                            )
                        )
                    }
                } catch (e: Exception) {
                    Log.d(TAG, "periodsTrackViewSet: ${e.message}")
                }

            }
            periodDatePicker.setOnClickListener {
                showDatePickerDialog(selectedDate = data.lastPeriodStratDate)
            }
            addData1.setOnClickListener {
                duringDaysTemp += 1
                duringDays.setText("$duringDaysTemp")
            }
            minusData1.setOnClickListener {
                if (duringDaysTemp > 1) {
                    duringDaysTemp -= 1
                }
                duringDays.setText("$duringDaysTemp")
            }
            addData2.setOnClickListener {
                cycleDaysTemp += 1
                cycleDays.setText("$cycleDaysTemp")
            }
            minusData2.setOnClickListener {
                if (cycleDaysTemp > 11) {
                    cycleDaysTemp -= 1
                }
                cycleDays.setText("$cycleDaysTemp")
            }
        }
    }

    // Function to show DatePickerDialog
    private fun showDatePickerDialog(
        context: Context = requireContext(),
        selectedDate: String = getCurrentDate(),
        isDialog: Boolean = false,
        exitText: EditText? = null
    ) {
        val calendar = Calendar.getInstance()

        // If selectedDate is provided, parse it into a Date object
        val date = selectedDate.let {
            SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(it)
        }

        // Set the calendar to the selected date or the current date
        date?.let {
            calendar.time = it
        }

        val datePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, dayOfMonth)

                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedCalendar.time)
                if (isDialog) {
                    exitText?.setText(formattedDate)
                }
                binding.lastPeriodStratDate.setText(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }

    private fun generateDaysForMonth(year: Int, month: Int): List<CalendarDay> {
        val daysList = mutableListOf<CalendarDay>()
        val calendar = Calendar.getInstance()

        // Set the calendar to the specified year and month
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month - 1) // Month is 0-based in Calendar API

        // Set the calendar to the first day of the month
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        // Find out the day of the week for the first day of the month
        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        // Calculate the number of empty cells to add before the first day of the month
        val numEmptyCells =
            if (firstDayOfWeek == Calendar.SUNDAY) 0 else firstDayOfWeek - Calendar.SUNDAY

        // Add empty cells before the first day of the month
        for (i in 1..numEmptyCells) {
            daysList.add(CalendarDay(0, false, android.R.color.transparent)) // Adding empty data
        }

        // Iterate through the days of the month
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        for (i in 1..daysInMonth) {
            val isSelected = false // For demonstration, let's assume the first day is selected
            val backgroundColor =
                if (isSelected) R.color.selected_color else android.R.color.transparent
            daysList.add(CalendarDay(i, isSelected, backgroundColor))
        }
        return daysList
    }

    private fun showCustomAlertDialog(
        context: Context = requireContext(),
        data: PeriodsData = Gson().fromJson(
            userData?.trackingData, PeriodsData::class.java
        )
    ) {

        var duringDaysTemp = data.duringDays
        var cycleDaysTemp = data.cycleDays

        // Inflate custom layout using View Binding
        val dialogBinding = DialogChangeDataBinding.inflate(LayoutInflater.from(context));

        val builder = AlertDialog.Builder(context)
        builder.setView(dialogBinding.root)

        val alertDialog = builder.create()
        with(dialogBinding) {
            lastPeriodStratDate.setText(data.lastPeriodStratDate)
            duringDays.setText("$duringDaysTemp")
            cycleDays.setText("$cycleDaysTemp")
            addData1.setOnClickListener {
                duringDaysTemp += 1
                duringDays.setText("$duringDaysTemp")
            }
            minusData1.setOnClickListener {
                if (duringDaysTemp > 1) {
                    duringDaysTemp -= 1
                }
                duringDays.setText("$duringDaysTemp")
            }
            addData2.setOnClickListener {
                cycleDaysTemp += 1
                cycleDays.setText("$cycleDaysTemp")
            }
            minusData2.setOnClickListener {
                if (cycleDaysTemp > 11) {
                    cycleDaysTemp -= 1
                }
                cycleDays.setText("$cycleDaysTemp")
            }
            startTracking.setOnClickListener {
                try {
                    val saveData = PeriodsData(
                        lastPeriodStratDate.text.toString(), duringDaysTemp, cycleDaysTemp
                    )
                    Log.d(TAG, "periodsTrackViewSet: $saveData")
                    if (userData != null) {
                        userData?.trackingData = Gson().toJson(saveData)
                        viewModel.insertUser(userData!!)
                        setViewLayout("periods_track")
                        viewModel.insertMenstrualDays(
                            MenstrualDays(
                                userId = AppPreferences.loginUuid.toString(),
                                lastPeriodStartDate = saveData.lastPeriodStratDate,
                                duringDays = saveData.duringDays,
                                usualCycleLength = saveData.cycleDays
                            )
                        )
                        alertDialog.dismiss()
                    }
                } catch (e: Exception) {
                    Log.d(TAG, "periodsTrackViewSet: ${e.message}")
                }
            }
            dialogBinding.periodDatePicker.setOnClickListener {
                showDatePickerDialog(
                    selectedDate = dialogBinding.lastPeriodStratDate.text.toString(),
                    isDialog = true,
                    exitText = dialogBinding.lastPeriodStratDate
                )
            }
        }


        // Create and show AlertDialog
        alertDialog.show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "WomenFragment"
        const val periodsCalculateMonth: Int = 5
    }

}