package com.project.dietively.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dietively.databinding.LayoutWeightItemBinding

class WeightAdapter(
    private var options: Array<String>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<WeightAdapter.WeightItemViewHolder>() {

    init {
        setHasStableIds(true)
    }

    class WeightItemViewHolder(val binding: LayoutWeightItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeightAdapter.WeightItemViewHolder {
        return WeightAdapter.WeightItemViewHolder(
            LayoutWeightItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return options.size
    }

    override fun onBindViewHolder(holder: WeightItemViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val o = options[position]
        with(holder.binding) {
            option.text = o
            option.setOnClickListener {
                listener.onClick(o)
            }
        }
    }

    interface OnClickListener {
        fun onClick(item: String)
    }
}