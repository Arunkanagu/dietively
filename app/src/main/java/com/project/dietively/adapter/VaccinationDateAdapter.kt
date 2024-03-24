package com.project.dietively.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.dietively.DietivelyApp
import com.project.dietively.R
import com.project.dietively.databinding.LayoutVaccinationBinding
import com.project.dietively.util.VaccinationDate
import com.project.dietively.util.classifyDate
import com.project.dietively.util.convertDateToString
import java.util.Date

class VaccinationDateAdapter(
    private var vaccinationList: List<VaccinationDate>,
) : RecyclerView.Adapter<VaccinationDateAdapter.VaccinationViewHolder>() {

    init {
        setHasStableIds(true)
    }

    class VaccinationViewHolder(val binding: LayoutVaccinationBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VaccinationDateAdapter.VaccinationViewHolder {
        return VaccinationDateAdapter.VaccinationViewHolder(
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
        with(holder.binding) {
            when (classifyDate(Date(vac.month))) {
                "isToday"->{
                    date.setBackgroundColor(ContextCompat.getColor(DietivelyApp.instance, R.color.select))
                    vaccina.setBackgroundColor(ContextCompat.getColor(DietivelyApp.instance, R.color.select))
                }
                "is pastday"->{
                    date.setBackgroundColor(ContextCompat.getColor(DietivelyApp.instance, R.color.app_white_300))
                    vaccina.setBackgroundColor(ContextCompat.getColor(DietivelyApp.instance, R.color.app_white_300))
                }
                "next coming date"->{

                    date.setBackgroundColor(ContextCompat.getColor(DietivelyApp.instance, R.color.round_edit_text_bg))
                    vaccina.setBackgroundColor(ContextCompat.getColor(DietivelyApp.instance, R.color.round_edit_text_bg))
                }
                else->{}
            }

            date . text = convertDateToString (Date(vac.month))
            vaccina . text = vac . vaccines . joinToString (", ")
        }
    }
}