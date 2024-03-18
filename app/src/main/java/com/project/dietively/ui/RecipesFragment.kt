package com.project.dietively.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
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
import com.google.android.material.textfield.TextInputEditText
import com.project.dietively.R
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentRecipesBinding
import com.project.dietively.databinding.LayoutChildDailogBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.viewmodel.AppViewModel
import java.util.Calendar


class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!
    private lateinit var alertDialog: AlertDialog
    private val viewModel: AppViewModel by activityViewModels()
    private val options = arrayOf("Man", "Woman", "Child Vaccinations")
    private var tracker = MutableLiveData<String>("")
    private var userData: UserProfile? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser.observe(viewLifecycleOwner) { u ->
            userData = u.find { it.email == AppPreferences.loginEmail }!!
            if (userData!!.tracking.isEmpty()) {
                viewControl()
            } else {
                viewControl(userData!!.tracking)
            }
        }
        tracker.observe(viewLifecycleOwner) { u ->
            Handler(Looper.getMainLooper()).postDelayed({
                if (u.isEmpty()) {
                    when (u) {
                        options[0] -> {}
                        options[1] -> {}
                        options[2] -> {
                            createCustomAlertDialog()
                        }
                    }
                }
            }, 1000)

        }
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.clear.setOnClickListener {
            userData!!.trackingData = ""
            userData!!.tracking = ""
            viewModel.insertUser(userData!!)
            viewControl()
        }

        binding.fab.setOnClickListener {
            showOptionsDialog()
        }
    }

    private fun viewControl(setName: String = "") {
        binding.fab.visibility = View.GONE
        binding.clear.visibility = View.GONE
        binding.childLayout.visibility = View.GONE

        when (setName) {
            options[2] -> {

                if (userData != null) {
                    val temp = userData?.trackingData?.split(",")
                    if (temp != null) {
                        if (temp.isNotEmpty()) {
                            binding.childLayout.visibility = View.VISIBLE
                            binding.name.text = "Baby name : ${temp[0]}"
                            binding.dob.text = "Baby's date of brith : ${temp[1]}"
                            binding.textView.text = options[2]

                            binding.clear.visibility = View.VISIBLE
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
                binding.fab.visibility = View.VISIBLE
                binding.textView.text = requireContext().getText(R.string.track_str)
            }
        }
    }

    private fun showOptionsDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Choose an Track")
        builder.setItems(options, DialogInterface.OnClickListener { dialog, which ->

            val selectedOption = options[which]
            when (selectedOption) {
                options[0] -> {}
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
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(selectedYear, selectedMonth, selectedDayOfMonth)
                val selectedDateInMillis = selectedCalendar.timeInMillis
                dateOfBirth.setText(selectedDate)
            },
            year,
            month,
            dayOfMonth
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

    companion object {
        const val TAG: String = "RecipesFragment"
    }

}