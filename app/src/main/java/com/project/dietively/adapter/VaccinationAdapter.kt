package com.project.dietively.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dietively.databinding.DailyFoodLayoutBinding
import com.project.dietively.databinding.LayoutVaccinationBinding
import com.project.dietively.roomdb.DailyData
import com.project.dietively.util.VaccinationSchedule
import com.project.dietively.util.VaccinationScheduleData

class VaccinationAdapter(
    private var vaccinationList: List<VaccinationSchedule> = VaccinationScheduleData().schedule,
) : RecyclerView.Adapter<VaccinationAdapter.VaccinationViewHolder>() {

    init {
        setHasStableIds(true)
    }

    class VaccinationViewHolder(val binding: LayoutVaccinationBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VaccinationAdapter.VaccinationViewHolder {
        return VaccinationAdapter.VaccinationViewHolder(
            LayoutVaccinationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return vaccinationList.size
    }

    override fun onBindViewHolder(holder: VaccinationViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val vac = vaccinationList[position]
        with(holder.binding){
            date.text = vac.month
            vaccina.text = vac.vaccines.joinToString(", ")

        }
    }
}