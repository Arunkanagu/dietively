package com.project.dietively.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.project.dietively.R
import com.project.dietively.databinding.FragmentSignUpBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.util.hideKeyboard
import com.project.dietively.util.isValidEmail
import com.project.dietively.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.UUID

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val arrayLayout = arrayListOf<LinearLayout>()

    private var userDate = UserProfile()

    private val viewModel: AppViewModel by activityViewModels()
    private var selectedGender = "Male"
    private var userProfileList: ArrayList<UserProfile> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToLogin.setOnClickListener {
            findNavController().popBackStack(R.id.loginFragment, false)
        }

        viewModel.getUser.observe(viewLifecycleOwner) {
            userProfileList = it as ArrayList<UserProfile>
            Log.d(TAG, "onViewCreated: $ {userProfileList}")
        }

        genderSelection()

        binding.info1.setOnClickListener { hideKeyboard(view) }
        binding.info2.setOnClickListener { hideKeyboard(view) }
        binding.linearLayout.setOnClickListener { hideKeyboard(view) }
        binding.constraintLayout.setOnClickListener { hideKeyboard(view) }
        arrayLayout.add(binding.info1)
        arrayLayout.add(binding.info2)
        binding.dateOfBirth.isClickable = false
        binding.dateOfBirth.isFocusable = false
        viewControl(0)
        binding.next.setOnClickListener {
            binding.userTextField1.error = ""
            binding.emailTextField.error = ""
            binding.mobileTextField.error = ""
            binding.passTextField.error = ""
            val user = binding.user.text.toString()
            val email = binding.email.text.toString()
            val mobile = binding.mobile.text.toString()
            val pass = binding.pass.text.toString()

            var allDone = true
            if (user.isEmpty()) {
                binding.userTextField1.error = "enter the name"
                allDone = false
            }

            if (mobile.length != 10) {
                binding.mobileTextField.error = "Enter the valid mobile number"
                allDone = false
            }
            if (mobile.length == 12 && !mobile.startsWith("91")) {
                binding.mobileTextField.error = "Enter the valid mobile number"
                allDone = false
            }
            if (!binding.email.text.toString().isValidEmail()) {
                binding.emailTextField.error = "Enter the valid Email ID"
                allDone = false
            }
            if (binding.pass.text.toString().length < 8) {
                binding.passTextField.error = "Enter the valid password"
                allDone = false
            }
            if (userProfileList.any { it.email == email }) {
                viewModel.toastMsgStr.postValue("This Email-ID already registered")
                allDone = false
            }
            if (allDone) {
                userDate.userId = UUID.randomUUID().toString()
                userDate.user = user
                userDate.email = email
                userDate.phone = mobile
                userDate.password = pass
                viewControl(1)
            }
        }
        binding.dateOfBirthBtn.setOnClickListener {
            showDatePickerDialog()
        }
        binding.signUp.setOnClickListener {
            if (binding.dateOfBirth.text.toString().isNullOrEmpty()) {
                binding.dobTextField.error = ""
            }
            userDate.dateOfBirth = binding.dateOfBirth.text.toString()
            userDate.age = binding.age.text.toString().toInt()
            userDate.genter = selectedGender
            Log.d(TAG, "onViewCreated: ${userDate}")
            viewModel.insertUser(userDate)
            findNavController().popBackStack()
        }
    }



    private fun viewControl(point: Int = 0) {

        arrayLayout.map { it.visibility = View.GONE }
        arrayLayout[point].visibility = View.VISIBLE
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->

                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Log.d(TAG, "showDatePickerDialog: $selectedDate")
                binding.age.setText(calculateAge(selectedDate).toString())
                binding.dateOfBirth.setText(selectedDate)
            },
            year,
            month,
            day
        )

        // Show the date picker dialog
        datePickerDialog.show()
    }

    fun calculateAge(dateOfBirth: String): Int {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dobDate = dateFormat.parse(dateOfBirth)
        val dobCalendar = Calendar.getInstance()
        dobCalendar.time = dobDate

        val todayCalendar = Calendar.getInstance()

        var age = todayCalendar.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR)
        if (todayCalendar.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        return age
    }

    private fun genderSelection() {
        binding.male.setOnClickListener {
            binding.male.setBackgroundResource(R.drawable.bg_gender)
            binding.female.setBackgroundResource(R.drawable.bg_unselect_gender)
            selectedGender = "Male"
        }
        binding.female.setOnClickListener {
            binding.male.setBackgroundResource(R.drawable.bg_unselect_gender)
            binding.female.setBackgroundResource(R.drawable.bg_gender)
            selectedGender = "Female"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "LoginFragment"
    }

}