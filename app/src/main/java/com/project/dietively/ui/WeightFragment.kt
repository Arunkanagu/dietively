package com.project.dietively.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.project.dietively.R
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentChildWeightBinding
import com.project.dietively.roomdb.BMIResult
import com.project.dietively.roomdb.Person
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.util.calculateBMI
import com.project.dietively.viewmodel.AppViewModel


class WeightFragment : Fragment() {

    private var _binding: FragmentChildWeightBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()
    private var userData: UserProfile? = null

    private var resultBMI: BMIResult = BMIResult()

    private var select = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChildWeightBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser.observe(viewLifecycleOwner) { u ->
            userData = u.find { it.userId == AppPreferences.loginUuid }!!
            clearText()
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.msg.isVisible) {
                        viewSetting("reset")
                    } else {
                        findNavController().popBackStack()
                    }
                }
            })
        viewSetting()
        binding.back.setOnClickListener {
            if (binding.msg.isVisible) {
                viewSetting("reset")
            } else {
                findNavController().popBackStack()
            }
        }
        binding.genderText.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gender_options,
            android.R.layout.simple_spinner_item
        )

        binding.genderText.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Do something with the selected item
                Log.d("Selected Gender", selectedItem)
                select = selectedItem.lowercase()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Another interface callback
            }
        }
        binding.calculateBtn.setOnClickListener {
            val data = getData()
            resultBMI = calculateBMI(
                data.weight,
                data.height,
                data.gender,
                data.age,
            )
            viewSetting(
                "show_msg",
                "BMI = ${resultBMI.bmi}\n\n This person is ${resultBMI.category}"
            )
        }
    }


    private fun viewSetting(mode: String = "calculate", btnMsg: String = "") {

        with(binding) {
            goTo.visibility = View.GONE
            when (mode) {
                "calculate", "reset" -> {
                    clearText()
                    msg.text = ""
                    msg.visibility = View.GONE
                    calculateBtn.text = getText(R.string.calu_str)
                }

                "show_msg" -> {
                    msg.visibility = View.VISIBLE
                    msg.text = btnMsg
                    //calculateBtn.text = ("Clear")
                }
            }
        }

    }

    private fun getData(): Person {
        return Person(
            weight = binding.weightText.text.toString().toDouble(),
            height = binding.heightText.text.toString().toDouble()/100,
            gender = select,
            age = binding.ageText.text.toString().toInt()
        )
    }

    private fun clearText() {
        binding.weightText.setText("0.0")
        binding.heightText.setText("0.0")
        binding.genderText.setSelection(0)
        binding.ageText.setText(userData?.age.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "WeightFragment"
    }
}