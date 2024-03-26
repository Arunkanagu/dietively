package com.project.dietively.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.dietively.DietivelyApp
import com.project.dietively.R
import com.project.dietively.roomdb.CalendarDay

class CalendarAdapter(private val days: List<CalendarDay>) :
    RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.calendar_day_item, parent, false)
        return CalendarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val day = days[position]
        holder.bind(day)
    }

    override fun getItemCount(): Int = days.size

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dayTextView: TextView = itemView.findViewById(R.id.dayTextView)

        fun bind(calendarDay: CalendarDay) {
            dayTextView.setBackgroundResource(calendarDay.backgroundColor)
            if (calendarDay.dayOfMonth.toString() != "0") {
                dayTextView.text = calendarDay.dayOfMonth.toString()
                if (calendarDay.isSelected) {
                    dayTextView.setTextColor(ContextCompat.getColor(DietivelyApp.instance,R.color.app_white_100))
                }else{
                    dayTextView.setTextColor(ContextCompat.getColor(DietivelyApp.instance,R.color.app_black_100))
                }
            } else {
                dayTextView.setBackgroundResource(android.R.color.transparent)
                dayTextView.text = ""
            }


        }
    }
}
