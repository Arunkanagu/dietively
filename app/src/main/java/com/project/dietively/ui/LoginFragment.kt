package com.project.dietively.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.project.dietively.R
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentLoginBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.util.isValidEmail
import com.project.dietively.viewmodel.AppViewModel


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()

    private var users: ArrayList<UserProfile> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.join.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }
        viewModel.getUser.observe(viewLifecycleOwner) {
            users = it as ArrayList<UserProfile>
        }
        binding.loginBtn.setOnClickListener {
            var allSet = true
            if (!binding.email.text.toString().isValidEmail()) {
                binding.emailTextField.error = "Enter the valid Email ID"
                allSet = false
            }

            if (binding.pass.text.toString()
                    .isEmpty() && binding.pass.text.toString().length <= 8
            ) {
                binding.passTextField.error = "Enter the valid Password"
                allSet = false
            }
            val data = users.find { it.email == binding.email.text.toString().trim() }
            Log.d(TAG, "onViewCreated: $users")
            if (data != null) {
                if (data.password == binding.pass.text.toString().trim()) {
                    AppPreferences.loginEmail = binding.email.text.toString().trim()
                    findNavController().navigate(R.id.homeFragment)
                } else {
                    Toast.makeText(requireContext(), "invalid email id & password", Toast.LENGTH_SHORT)
                        .show()
                }
            }else{
                Toast.makeText(requireContext(), "user not fount", Toast.LENGTH_SHORT)
                    .show()
            }


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