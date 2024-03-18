package com.project.dietively.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dietively.databinding.FoodItemsBinding
import com.project.dietively.roomdb.FoodItem

class FoodAdapter(
    private var foodList: List<FoodItem>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    init {
        setHasStableIds(true)
    }

    class FoodViewHolder(val binding: FoodItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodAdapter.FoodViewHolder(
            FoodItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val food = foodList[position]
        with(holder.binding) {
            foodName.text = food.name
            protein.text = "protein : " + food.protein
            calorie.text = "calories : " + food.calories
            fat.text = "fat : " + food.fat
            carbohydrates.text = "carbohydrates : " + food.carbohydrates
            item.setOnClickListener {
                listener.onClick(food)
            }
            if (food.img != 0) {
                image.setImageResource(food.img)
            }

        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun updateData(newDataList: List<FoodItem>) {
        foodList = newDataList
        notifyDataSetChanged() // Notify adapter that the dataset has changed
    }


    interface OnClickListener {
        fun onClick(item: FoodItem)
    }
}