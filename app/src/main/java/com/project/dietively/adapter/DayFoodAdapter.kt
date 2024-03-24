package com.project.dietively.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dietively.DietivelyApp
import com.project.dietively.R
import com.project.dietively.databinding.DailyFoodLayoutBinding
import com.project.dietively.roomdb.DailyData

class DayFoodAdapter(
    private var foodList: List<DailyData>,
    private val listener: DayFoodAdapter.OnClickListener
) : RecyclerView.Adapter<DayFoodAdapter.FoodViewHolder>() {

    init {
        setHasStableIds(true)
    }
    class FoodViewHolder(val binding: DailyFoodLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return DayFoodAdapter.FoodViewHolder(
            DailyFoodLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val food = foodList[position]
        with(holder.binding){
            foodName.text = food.foodItemName
            quantity.text = DietivelyApp.instance.getString(R.string.quantity_str)+" ${ food.addCount.toString() }"
            calories.text = "calories : ${"%.2f".format(food.calories.toFloat())}"
            protein.text = "protein : ${"%.2f".format(food.protein.toFloat())}"
            fat.text = "fat : ${"%.2f".format(food.fat.toFloat())}"
            carbohydrates.text = "carbohydrates : ${"%.2f".format(food.carbohydrates.toFloat())}"
            removeFood.setOnClickListener {
                listener.onClick(food)
            }
        }
    }

    interface OnClickListener {
        fun onClick(item: DailyData)
    }

}