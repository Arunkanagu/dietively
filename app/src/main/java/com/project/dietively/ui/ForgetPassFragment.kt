package com.project.dietively.ui

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.project.dietively.R
import com.project.dietively.databinding.FragmentForgetPassBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.util.isEmailValid
import com.project.dietively.viewmodel.AppViewModel


class ForgetPassFragment : Fragment() {
    private var _binding: FragmentForgetPassBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()

    private var users: ArrayList<UserProfile> = arrayListOf()
    private var email = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForgetPassBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser.observe(viewLifecycleOwner){
            users.addAll(it)
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.emailCardView.isVisible){
                    findNavController().popBackStack()
                }else{
                    setCardView()
                }

            }
        })
        setCardView()
        buttonAction()
        binding.newPass.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        binding.confirmPass.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
    }

    private fun buttonAction() {
        binding.changePassBtn.setOnClickListener {
            email = binding.email.text.toString()
            if (isEmailValid(email)) {
                if (users.any { it.email == email }){
                    setCardView(false)
                }else{
                    viewModel.toastMsgStr.postValue("No user id find")
                }
            } else {
                viewModel.toastMsgStr.postValue("Email is not valid.")
            }

        }
        binding.setNewPassBtn.setOnClickListener {
            val newPass = binding.newPass.text.toString()
            val confirmPass = binding.confirmPass.text.toString()
            if (newPass.length < 8 || confirmPass.length < 8) {
                viewModel.toastMsgStr.postValue("Password must be at least 8 characters long.")
            } else {
                if (newPass == confirmPass) {
                    val u = users.find { it.email == email }
                    if (u != null) {
                        u.password = newPass
                        viewModel.insertUser(u)
                        viewModel.toastMsgStr.postValue("New Password updated successfully.")
                        findNavController().popBackStack(R.id.loginFragment,false)
                    }else{
                        viewModel.toastMsgStr.postValue("No user id find")
                    }
                } else {
                    viewModel.toastMsgStr.postValue("Passwords do not match")
                }
            }
        }
        binding.backToLogin.setOnClickListener {
            findNavController().popBackStack(R.id.loginFragment,false)
        }
    }




    private fun setCardView(viewEmail:Boolean = true ) {
        if (viewEmail){
            binding.emailCardView.visibility = View.VISIBLE
            binding.PasswordCardView.visibility = View.GONE
        }else{
            binding.emailCardView.visibility = View.GONE
            binding.PasswordCardView.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "ForgetPassFragment"
    }
}