package com.project.dietively.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.project.dietively.R
import com.project.dietively.commen.AppPreferences
import com.project.dietively.databinding.FragmentProgressBinding
import com.project.dietively.util.getCurrentDate
import com.project.dietively.util.getDate
import com.project.dietively.viewmodel.AppViewModel


class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.getUserDailyData.observe(viewLifecycleOwner) { data ->
            val list = data.filter { getCurrentDate() == getDate(it.date.toLong()) && it.userId == AppPreferences.loginEmail }

            var calSum = 0f
            var proSum = 0f
            var carSum = 0f
            var fatSum = 0f
            list.forEach {
                calSum += it.calories.toFloat() * it.addCount
                proSum += it.protein.toFloat() * it.addCount
                carSum += it.carbohydrates.toFloat() * it.addCount
                fatSum += it.fat.toFloat() * it.addCount
            }
            binding.cal.text = "${"%.1f".format(calSum)}"
            binding.pro.text = "${"%.1f".format(proSum)}"
            binding.car.text = "${"%.1f".format(carSum)}"
            binding.fat.text = "${"%.1f".format(fatSum)}"

            setChart(generatePieEntries(calSum,
                    proSum,
                    carSum,
                    fatSum))
        }


    }

    // Generate sample pie chart data
    private fun generatePieEntries(
        calSum: Float = 0f,
        proSum: Float = 0f,
        carSum: Float = 0f,
        fatSum: Float = 0f
    ): ArrayList<PieEntry> {
        val totalSum = calSum + proSum + carSum + fatSum

        val entries: ArrayList<PieEntry> = ArrayList()
        if (totalSum != 0f) {
            entries.add(PieEntry((calSum / totalSum) * 100, getString(R.string.calorie)))
            entries.add(PieEntry((proSum / totalSum) * 100, getString(R.string.protein)))
            entries.add(PieEntry((carSum / totalSum) * 100, getString(R.string.carbohydrates)))
            entries.add(PieEntry((fatSum / totalSum) * 100, getString(R.string.fat)))
        }
        return entries
    }

    private fun setChart(generatePieEntries: ArrayList<PieEntry>) {

        binding.date.text = getCurrentDate()

        val pieChart = binding.pieChart
        val dataSet = PieDataSet(generatePieEntries, "")
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
        val data = PieData(dataSet)
        pieChart.setData(data)
        pieChart.holeRadius = 30f
        pieChart.transparentCircleRadius = 40f
        pieChart.setDrawEntryLabels(true)
        pieChart.description.isEnabled = false
        pieChart.animateY(800)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG: String = "ProgressFragment"
    }

}