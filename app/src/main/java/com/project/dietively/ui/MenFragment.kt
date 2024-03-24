package com.project.dietively.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.project.dietively.R
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentMenBinding
import com.project.dietively.roomdb.UserProfile
import com.project.dietively.roomdb.WorkoutView
import com.project.dietively.util.GymFood_HTML
import com.project.dietively.viewmodel.AppViewModel


class MenFragment : Fragment() {
    private var _binding: FragmentMenBinding? = null
    private val binding get() = _binding!!

    private val workOutTitle: ArrayList<WorkoutView> = arrayListOf()
    private val basicWorkOut: ArrayList<WorkoutView> = arrayListOf()

    private val viewModel: AppViewModel by activityViewModels()
    private var userData: UserProfile? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser.observe(viewLifecycleOwner) { u ->
            userData = u.find { it.email == AppPreferences.loginEmail }!!
        }
        setLayoutView()
        setBasicWorkout()

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.webView.canGoBack()) {
                        binding.webView.goBack() // Go back if there's history
                    } else {
                        if (binding.mainLayout.isVisible) {
                            //findNavController().popBackStack()
                            findNavController().popBackStack(R.id.homeFragment, false)
                        } else {
                            setLayoutView()
                        } // Otherwise, let the system handle the back button
                    }

                }
            })

        binding.workoutPlanBtn.setOnClickListener { setLayoutView("workout") }
        binding.foodPlanBtn.setOnClickListener { setLayoutView("food") }
        binding.webPlanBtn.setOnClickListener { setLayoutView("web") }
        binding.clear.setOnClickListener { _ ->
            userData!!.trackingData = ""
            userData!!.tracking = ""
            viewModel.insertUser(userData!!)
            findNavController().popBackStack(R.id.recipesFragment, false)
        }
        binding.back.setOnClickListener { _ ->
            if (binding.mainLayout.isVisible) {
                findNavController().popBackStack(R.id.homeFragment, false)
            } else {
                setLayoutView()
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setLayoutView(screen: String = "main") {
        with(binding) {
            mainLayout.visibility = View.GONE
            workoutLayout.visibility = View.GONE
            foodLayout.visibility = View.GONE
            webView.visibility = View.GONE
            when (screen) {
                "main" -> {
                    mainLayout.visibility = View.VISIBLE
                }

                "food" -> {
                    foodLayout.visibility = View.VISIBLE
                    setFoodView()
                }

                "workout" -> {
                    workoutLayout.visibility = View.VISIBLE

                }

                "web"->{
                    webView.visibility = View.VISIBLE
                    webView.setWebViewClient(WebViewClient())
                    val settings: WebSettings = webView.settings
                    settings.javaScriptCanOpenWindowsAutomatically = true
                    settings.builtInZoomControls = true
                    settings.javaScriptEnabled = true
                    settings.databaseEnabled = true
                    settings.domStorageEnabled = true
                    settings.setGeolocationEnabled(true)
                    webView.loadUrl("https://www.health.harvard.edu/topics/diet-and-weight-loss")
                }

                else -> {

                }
            }
        }
    }

    private fun setFoodView() {

        binding.foodView .loadDataWithBaseURL(null, GymFood_HTML, "text/html", "UTF-8", null)
    }

    private fun setBasicWorkout() {
        workOutTitle.add(WorkoutView(binding.workoutTitle1, binding.workoutTitleStatus1))
        basicWorkOut.add(WorkoutView(binding.basic1, binding.basicStatus1))
        basicWorkOut.add(WorkoutView(binding.basic2, binding.basicStatus2))
        basicWorkOut.add(WorkoutView(binding.basic3, binding.basicStatus3))
        basicWorkOut.add(WorkoutView(binding.basic4, binding.basicStatus4))
        basicWorkOut.add(WorkoutView(binding.basic5, binding.basicStatus5))
        basicWorkOut.add(WorkoutView(binding.basic6, binding.basicStatus6))
        basicWorkOut.add(WorkoutView(binding.basic7, binding.basicStatus7))
        basicWorkOut.add(WorkoutView(binding.basic8, binding.basicStatus8))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "MenFragment"
    }
}