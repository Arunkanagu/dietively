package com.project.dietively.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.textfield.TextInputEditText
import com.project.dietively.R
import com.project.dietively.adapter.ImageAdapter
import com.project.dietively.adapter.VaccinationAdapter
import com.project.dietively.adapter.VaccinationDateAdapter
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentRecipesBinding
import com.project.dietively.databinding.LayoutChildDailogBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.util.VaccinationDate
import com.project.dietively.util.VaccinationSchedule
import com.project.dietively.util.VaccinationScheduleData
import com.project.dietively.util.addMonthsToDate
import com.project.dietively.util.addYearsToDate
import com.project.dietively.util.convertDateToString
import com.project.dietively.util.convertStringToDate
import com.project.dietively.util.extractNumbersFromList
import com.project.dietively.util.extractYearsFromString
import com.project.dietively.viewmodel.AppViewModel
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import kotlin.collections.ArrayList


class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!
    private lateinit var alertDialog: AlertDialog
    private val viewModel: AppViewModel by activityViewModels()
    private val options = arrayOf("Man", "Woman", "Child Vaccinations")
    private var tracker = MutableLiveData<String>("")
    private var userData: UserProfile? = null

    private lateinit var viewPager: ViewPager2
    private val images = listOf(
        R.drawable.img_man, R.drawable.img_woman, R.drawable.img_child
    )
    private var currentPage = 0
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser.observe(viewLifecycleOwner) { u ->
            userData = u.find { it.email == AppPreferences.loginEmail }
            if (userData != null) {
                if (userData!!.tracking.isEmpty()) {
                    if (userData!!.age > 5) {
                        if (userData!!.genter == "Male") {
                            userData!!.tracking = options[0]
                            userData!!.trackingData = TextUtils.join(",", arrayOf("", ""))
                            userData?.let { it1 -> viewModel.insertUser(it1) }
                            viewControl("Man")
                        } else if (userData!!.genter == "Female") {
                            userData!!.tracking = options[1]
                            userData!!.trackingData = TextUtils.join(",", arrayOf("", ""))
                            userData?.let { it1 -> viewModel.insertUser(it1) }
                            viewControl("Woman")
                        }
                    } else {
                        if (userData != null) {
                            userData!!.tracking = options[2]
                            userData!!.trackingData = TextUtils.join(",", arrayOf(userData!!.user, userData!!.dateOfBirth))
                        }
                        userData?.let { it1 -> viewModel.insertUser(it1) }
                        createCustomAlertDialog()
                    }
                } else {
                    viewControl(userData!!.tracking)
                }

            }

            Log.d(TAG, "onViewCreated:  $userData")
        }
        /*tracker.observe(viewLifecycleOwner) { u ->
            Handler(Looper.getMainLooper()).postDelayed({
                if (u.isEmpty()) {
                    when (u) {
                        options[0] -> {
                            if (userData != null) {
                                userData!!.tracking = options[0]
                                userData!!.trackingData = TextUtils.join(",", arrayOf("", ""))
                            }
                            userData?.let { it1 -> viewModel.insertUser(it1) }

                            Log.d(TAG, "onViewCreated: $userData")
                            findNavController().navigate(R.id.menFragment)
                        }

                        options[1] -> {}
                        options[2] -> {
                            createCustomAlertDialog()
                        }
                    }
                }
            }, 1000)

        }*/
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.clear.setOnClickListener {
            userData!!.trackingData = ""
            userData!!.tracking = ""
            viewModel.insertUser(userData!!)
            //viewControl()
        }

        binding.fab.setOnClickListener {
            //showOptionsDialog()
        }


    }

    private fun setViewPager() {
        // Set up adapter for ViewPager
        val adapter = ImageAdapter(images)
        binding.idelLayout.visibility = View.VISIBLE
        binding.childLayout.visibility = View.GONE
        viewPager = binding.viewPager
        viewPager.adapter = adapter

        // Auto-scroll handler
        handler = Handler(Looper.getMainLooper())
        currentPage = 0
        runnable = Runnable {
            viewPager.setCurrentItem(currentPage++, true)
            if (currentPage >= images.size) {
                currentPage = 0
            }
            handler.postDelayed(runnable, AUTO_SCROLL_DELAY)
        }

        // Start auto-scrolling
        handler.postDelayed(runnable, AUTO_SCROLL_DELAY)
    }

    private fun viewControl(setName: String = "") {
        binding.fab.visibility = View.GONE
        binding.clear.visibility = View.GONE
        binding.childLayout.visibility = View.GONE
        binding.idelLayout.visibility = View.GONE

        when (setName) {
            options[0] -> {
                findNavController().navigate(R.id.menFragment)
            }

            options[2] -> {
                if (this::handler.isInitialized) {
                    handler.removeCallbacks(runnable)
                }
                if (userData != null) {
                    val temp = userData?.trackingData?.split(",")
                    if (temp != null) {
                        if (temp.isNotEmpty()) {
                            binding.childLayout.visibility = View.VISIBLE
                            binding.name.text = "Baby name : ${temp[0]}"
                            binding.dob.text = "Baby's date of brith : ${temp[1]}"
                            binding.vaccinationList.adapter = VaccinationAdapter()
                            binding.textView.text = options[2]
                            binding.clear.visibility = View.VISIBLE
                            var dateOfVac = calculateVaVaccinationDate(temp[1])
                            val next = findNextVaccination(dateOfVac)
                            if (next != null) {
                                binding.nextDate.text = convertDateToString(Date(next.month))
                                binding.nextVac.text = next.vaccines.joinToString(", ")
                            } else {
                                binding.nextDate.text = "no date"
                                binding.nextVac.text = "no date"
                            }
                            binding.vaccinationDateList.adapter = VaccinationDateAdapter(dateOfVac)

                        } else {
                            binding.fab.visibility = View.VISIBLE
                            binding.textView.text = requireContext().getText(R.string.track_str)
                        }
                    } else {
                        binding.fab.visibility = View.VISIBLE
                        binding.textView.text = requireContext().getText(R.string.track_str)
                    }
                }
            }

            else -> {
                binding.idelLayout.visibility = View.VISIBLE
                binding.fab.visibility = View.VISIBLE
                binding.textView.text = requireContext().getText(R.string.track_str)
                setViewPager()
            }
        }
    }


    private fun showOptionsDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Choose an Track")
        builder.setItems(options, DialogInterface.OnClickListener { dialog, which ->

            val selectedOption = options[which]
            when (selectedOption) {
                options[0] -> {
                    if (userData != null) {
                        userData!!.tracking = options[0]
                        userData!!.trackingData = TextUtils.join(",", arrayOf("", ""))
                    }
                    userData?.let { it1 -> viewModel.insertUser(it1) }

                    Log.d(TAG, "onViewCreated: $userData")
                    findNavController().navigate(R.id.menFragment)
                }

                options[1] -> {}
                options[2] -> {
                    createCustomAlertDialog()
                }
            }

        })
        builder.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (this::handler.isInitialized) {
            handler.removeCallbacks(runnable)
        }
        _binding = null
    }

    private fun showDatePickerDialog(dateOfBirth: TextInputEditText) {
        // Get current date
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        // Create date picker dialog
        val datePickerDialog = DatePickerDialog(
            requireContext(), { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(selectedYear, selectedMonth, selectedDayOfMonth)
                val selectedDateInMillis = selectedCalendar.timeInMillis
                dateOfBirth.setText(selectedDate)
            }, year, month, dayOfMonth
        )

        // Show the date picker dialog
        datePickerDialog.show()
    }

    private fun createCustomAlertDialog() {
        try {
            val builder = AlertDialog.Builder(requireContext())
            val bindingAlert = LayoutChildDailogBinding.inflate(layoutInflater)
            builder.setView(bindingAlert.root)
            builder.setCancelable(false)
            alertDialog = builder.create()
            bindingAlert.startTrack.setOnClickListener {
                val babyName = bindingAlert.name.text.toString()
                val babyDOB = bindingAlert.dateOfBirth.text.toString()
                val data: Array<String> = arrayOf(babyName, babyDOB)
                if (userData != null) {
                    userData!!.tracking = options[2]
                    userData!!.trackingData = TextUtils.join(",", arrayOf(babyName, babyDOB))
                }
                userData?.let { it1 -> viewModel.insertUser(it1) }
                alertDialog.dismiss()
            }
            bindingAlert.dateOfBirthBtn.setOnClickListener {
                showDatePickerDialog(bindingAlert.dateOfBirth)
            }
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            alertDialog.show()
        } catch (e: Exception) {
            Log.e(HomeFragment.TAG, "showDialog: ${e.message.toString()}")
        }
    }

    private fun calculateVaVaccinationDate(dobStr: String): List<VaccinationDate> {
        val dateList = arrayListOf<VaccinationDate>()
        val schedule = VaccinationScheduleData().schedule
        Log.d(TAG, "calculateVaVaccinationDate: $dobStr")
        val dob = convertStringToDate(dobStr)

        if (dob != null) {
            schedule.forEach { it ->
                if (it.month == "Birth") {
                    dateList.add(VaccinationDate(dob.time, ArrayList(it.vaccines)))
                    Log.d(TAG, "calculateVaVaccinationDate: ${convertDateToString(dob)}")
                } else if (it.month.contains("Months")) {
                    if (it.month.contains(" – ")) {
                        val monthStr = it.month.replace("Months", "").trim()
                        val range = monthStr.split(" – ").map { n -> n.trim() }
                        Log.d(TAG, "calculateVaVaccinationDate: range $range")
                        for (i in range[0].toInt()..range[1].toInt()) {
                            val addedDate = addMonthsToDate(dob, i)
                            Log.d(
                                TAG, "calculateVaVaccinationDate: ${convertDateToString(addedDate)}"
                            )
                            if (!dateList.any { v -> v.month == addedDate.time }) {
                                dateList.add(
                                    VaccinationDate(
                                        addedDate.time, ArrayList(it.vaccines)
                                    )
                                )
                            } else {
                                dateList.find { v -> v.month == addedDate.time }?.vaccines?.addAll(
                                    it.vaccines
                                )
                            }
                        }

                    } else {
                        val addMonth = it.month.replace("Months", "").trim().toInt()
                        val addedDate = addMonthsToDate(dob, addMonth)
                        Log.d(TAG, "calculateVaVaccinationDate: ${convertDateToString(addedDate)}")
                        if (!dateList.any { v -> v.month == addedDate.time }) {
                            dateList.add(VaccinationDate(addedDate.time, ArrayList(it.vaccines)))
                        } else {
                            dateList.find { v -> v.month == addedDate.time }?.vaccines?.addAll(it.vaccines)
                        }
                    }

                } else if (it.month.contains("Years")) {
                    if (it.month.contains("(Girls)")) {

                    } else {
                        val yearStr = it.month.replace("Years", "").trim()
                        val range = yearStr.split(" – ").map { n -> n.trim() }
                        for (i in range[0].toInt()..range[1].toInt()) {
                            val addedDate = addYearsToDate(dob, i)
                            Log.d(
                                TAG,
                                "calculateVaVaccinationDate: y ${convertDateToString(addedDate)}"
                            )
                            if (!dateList.any { v -> v.month == addedDate.time }) {
                                dateList.add(
                                    VaccinationDate(
                                        addedDate.time, ArrayList(it.vaccines)
                                    )
                                )
                            } else {
                                dateList.find { v -> v.month == addedDate.time }?.vaccines?.addAll(
                                    it.vaccines
                                )
                            }
                        }
                    }
                } else if (it.month.contains("Year")) {
                    val years = extractYearsFromString(it.month)
                    var temp = it.month.replace(" Year", "")
                    temp = temp.replace(",", "")
                    temp = temp.replace(" and", "")
                    val lastYear = extractNumbersFromList(temp.split(" "))
                    Log.w(
                        TAG, "calculateVaVaccinationDate:  ${lastYear} => ${years}}"
                    )
                    lastYear.forEach { d ->
                        val addedDate = addYearsToDate(dob, d)
                        Log.d(
                            TAG, "calculateVaVaccinationDate: y ${convertDateToString(addedDate)}"
                        )
                        if (!dateList.any { v -> v.month == addedDate.time }) {
                            dateList.add(VaccinationDate(addedDate.time, ArrayList(it.vaccines)))
                        } else {
                            dateList.find { v -> v.month == addedDate.time }?.vaccines?.addAll(it.vaccines)
                        }
                    }
                }
            }
            return dateList.sortedBy { it.month }
        } else {
            return listOf()
        }
    }

    fun findNextVaccination(vaccinationDates: List<VaccinationDate>): VaccinationDate? {
        // Get current month in milliseconds since epoch
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        // Set time to end of day
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        val endOfDayMillis = calendar.timeInMillis
        // Find the next vaccination date
        for (vaccinationDate in vaccinationDates) {
            if (vaccinationDate.month >= endOfDayMillis) {
                return vaccinationDate
            }
        }
        return null
    }


    companion object {
        const val TAG: String = "RecipesFragment"
        private const val AUTO_SCROLL_DELAY = 3000L // 3 seconds delay
    }

}