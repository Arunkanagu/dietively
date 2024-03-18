package com.project.dietively.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.project.dietively.R
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentProfileBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.viewmodel.AppViewModel


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()

    private var userProfile: UserProfile = UserProfile()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.getUser.observe(viewLifecycleOwner) { user ->
            val loginEmail = AppPreferences.loginEmail
            if (loginEmail != null) {
                userProfile = user.find { it.email == loginEmail }!!
                fillData(userProfile)
            }
        }

        binding.logout.setOnClickListener {
            showLogoutConfirmationDialog()
        }

    }

    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { dialog, which ->
                AppPreferences.loginEmail = ""
                findNavController().popBackStack(R.id.loginFragment,false)
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
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "ProfileFragment"
    }

}