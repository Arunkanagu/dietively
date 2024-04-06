package com.project.dietively.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.project.dietively.R
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentProfileBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()

    private var userProfile: UserProfile = UserProfile()

    private var userList: ArrayList<UserProfile> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.showDetailsLayour.isVisible) {
                        findNavController().popBackStack()
                    } else {
                        binding.showDetailsLayour.visibility = View.VISIBLE
                        binding.editProfileLayout.visibility = View.GONE
                    }

                }
            })

        viewModel.getUser.observe(viewLifecycleOwner) { user ->
            userList.clear()
            userList.addAll(user)
            val loginUuid = AppPreferences.loginUuid
            if (loginUuid != null) {
                userProfile = user.find { it.userId == loginUuid }!!
                fillData(userProfile)
            }
        }

        binding.logout.setOnClickListener {
            showLogoutConfirmationDialog()
        }

        binding.showDetailsLayour.visibility = View.VISIBLE
        binding.editProfileLayout.visibility = View.GONE
        binding.editDate.inputType = InputType.TYPE_NULL
        binding.editAge.inputType = InputType.TYPE_NULL

        binding.editDate.isClickable = false
        binding.editDate.isFocusable = false
        binding.editAge.isClickable = false
        binding.editAge.isFocusable = false

        binding.editDate.setOnClickListener {
            showDatePickerDialog()
        }
        binding.editAge.setOnClickListener {
            showDatePickerDialog()
        }

        binding.editBtn.setOnClickListener {
            binding.showDetailsLayour.visibility = View.GONE
            binding.editProfileLayout.visibility = View.VISIBLE
            with(binding) {
                editName.setText(userProfile.user)
                editAge.setText(userProfile.age.toString())
                editDate.setText(userProfile.dateOfBirth)
                editEmail.setText(userProfile.email)
                editMobNo.setText(userProfile.phone)
            }
        }

        binding.cancelBtn.setOnClickListener {
            binding.showDetailsLayour.visibility = View.VISIBLE
            binding.editProfileLayout.visibility = View.GONE
            with(binding) {
                editName.setText(userProfile.user)
                editAge.setText(userProfile.age.toString())
                editDate.setText(userProfile.dateOfBirth)
                editEmail.setText(userProfile.email)
                editMobNo.setText(userProfile.phone)
            }
        }
        binding.saveBtn.setOnClickListener {
            val temp = userProfile
            with(binding) {
                val userName = editName.text.toString()
                val userAge = editAge.text.toString().toIntOrNull()
                val userDateOfBirth = editDate.text.toString()
                val userEmail = editEmail.text.toString()
                val userMobileNumber = editMobNo.text.toString()

                // Null check and email validation
                if (userName.isNotBlank() && userAge != null && userDateOfBirth.isNotBlank() &&
                    userEmail.isNotBlank() && isValidEmail(userEmail) && isValidPhoneNumber(
                        userMobileNumber
                    )
                ) {
                    if (userList.any { it.email == userEmail && userProfile.email != userEmail }) {
                        viewModel.toastMsgStr.postValue("This Email ID already registered.")
                    } else if (userAge > 122) {
                        viewModel.toastMsgStr.postValue("Invalid age")
                    } else {
                        temp.user = userName
                        temp.age = userAge
                        temp.dateOfBirth = userDateOfBirth
                        temp.email = userEmail
                        temp.phone = userMobileNumber

                        // Insert user data only if all fields are valid
                        viewModel.insertUser(temp)
                        binding.showDetailsLayour.visibility = View.VISIBLE
                        binding.editProfileLayout.visibility = View.GONE
                    }
                } else
                    Toast.makeText(
                        context,
                        "Invalid input. Please check your input fields.",
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }

    }

    private fun showDatePickerDialog(dateString: String = binding.editDate.text.toString()) {
        val calendar = Calendar.getInstance()

        val dateParts = dateString.split("/")
        val year = dateParts[2].toInt()
        val month = dateParts[1].toInt() - 1 // Months are 0-indexed in Calendar
        val day = dateParts[0].toInt()

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->

                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Log.d(SignUpFragment.TAG, "showDatePickerDialog: $selectedDate")
                binding.editAge.setText(calculateAge(selectedDate).toString())
                binding.editDate.setText(selectedDate)
            },
            year,
            month,
            day
        )
        // Set maximum date
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        // Show the date picker dialog
        datePickerDialog.show()
    }

    private fun calculateAge(dateOfBirth: String): Int {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dobDate = dateFormat.parse(dateOfBirth)
        val dobCalendar = Calendar.getInstance()
        if (dobDate != null) {
            dobCalendar.time = dobDate
        }

        val todayCalendar = Calendar.getInstance()

        var age = todayCalendar.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR)
        if (todayCalendar.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        return age
    }

    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { dialog, which ->
                AppPreferences.loginUuid = ""
                findNavController().popBackStack(R.id.loginFragment, false)
            }
            .setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    private fun fillData(userProfile: UserProfile) {
        with(binding) {
            name.text = ": ${userProfile.user}"
            age.setText(": ${userProfile.age}")
            dob.text = ": ${userProfile.dateOfBirth}"
            email.text = ": ${userProfile.email}"
            mobileNo.text = ": ${userProfile.phone}"
            gender.text = ": ${userProfile.genter}"

            editName.setText(userProfile.user)
            editAge.setText(userProfile.age.toString())
            editDate.setText(userProfile.dateOfBirth)
            editEmail.setText(userProfile.email)
            editMobNo.setText(userProfile.phone)
            //gender.setText(userProfile.user)
        }
    }

    // Email validation function
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    // Mobile number validation function
    private fun isValidPhoneNumber(phone: String): Boolean {
        val phonePattern = "\\d{10}"
        return phone.length == 10 || (phone.length == 12 && phone.startsWith("91"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "ProfileFragment"
    }

}