package com.project.dietively.util

import com.project.dietively.R
import com.project.dietively.roomdb.FoodItem


fun getFoodItemList(): ArrayList<FoodItem> {

    val foodItems = arrayListOf<FoodItem>()
    foodItems.add(
        FoodItem(
            "Idly",
            "50-60 kcal",
            "2-3 grams",
            "10-12 grams",
            "0.2-0.5 grams",
            "Breakfast",
            R.raw.image30
        )
    )
    foodItems.add(
        FoodItem(
            "Dosa",
            "120-150 kcal",
            "2-4 grams",
            "20-25 grams",
            "2-4 grams",
            "Breakfast",
            R.raw.image32
        )
    )
    foodItems.add(
        FoodItem(
            "Upma",
            "150-180 kcal",
            "3-5 grams",
            "20-25 grams",
            "5-7 grams",
            "Breakfast",
            R.raw.image31
        )
    )
    foodItems.add(
        FoodItem(
            "Pongal",
            "200-250 kcal",
            "5-8 grams",
            "30-35 grams",
            "5-8 grams",
            "Breakfast",
            R.raw.image34
        )
    )
    foodItems.add(
        FoodItem(
            "Poori",
            "150-200 kcal",
            "3-4 grams",
            "20-25 grams",
            "7-10 grams",
            "Breakfast",
            R.raw.image33
        )
    )
    foodItems.add(
        FoodItem(
            "Puttu",
            "150-180 kcal",
            "2-4 grams",
            "25-30 grams",
            "2-4 grams",
            "Breakfast",
            R.raw.image36
        )
    )
    foodItems.add(
        FoodItem(
            "Idiyappam",
            "100-120 kcal",
            "2-3 grams",
            "20-25 grams",
            "1-2 grams",
            "Breakfast",
            R.raw.image35
        )
    )
    foodItems.add(
        FoodItem(
            "Sambar Rice",
            "250-300 kcal",
            "5-8 grams",
            "50-60 grams",
            "3-6 grams",
            "Lunch (veg)",
            R.raw.image42
        )
    )
    foodItems.add(
        FoodItem(
            "Rasam Rice",
            "150-200 kcal",
            "2-4 grams",
            "30-40 grams",
            "1-3 grams",
            "Lunch (veg)",
            R.raw.image37
        )
    )
    foodItems.add(
        FoodItem(
            "Lemon Rice",
            "200-250 kcal",
            "3-5 grams",
            "40-50 grams",
            "3-5 grams",
            "Lunch (veg)",
            R.raw.image41
        )
    )
    foodItems.add(
        FoodItem(
            "Tomato Rice",
            "250-300 kcal",
            "5-7 grams",
            "45-55 grams",
            "4-6 grams",
            "Lunch (veg)",
            R.raw.image42
        )
    )
    foodItems.add(
        FoodItem(
            "Curd Rice",
            "200-250 kcal",
            "4-6 grams",
            "30-40 grams",
            "5-8 grams",
            "Lunch (veg)",
            R.raw.image40
        )
    )
    foodItems.add(
        FoodItem(
            "Vegetable Biryani",
            "300-400 kcal",
            "6-10 grams",
            "50-60 grams",
            "8-12 grams",
            "Lunch (veg)",
            R.raw.image39
        )
    )
    foodItems.add(
        FoodItem(
            "Chicken Biryani",
            "300-400 kcal",
            "20-25 grams",
            "40-50 grams",
            "10-15 grams",
            "Lunch (non veg)",
            R.raw.image43
        )
    )
    foodItems.add(
        FoodItem(
            "Fish Curry",
            "150-250 kcal",
            "15-20 grams",
            "5-10 grams",
            "8-12 grams",
            "Lunch (non veg)",
            R.raw.image44
        )
    )
    foodItems.add(
        FoodItem(
            "Mutton Curry",
            "300-400 kcal",
            "20-25 grams",
            "5-10 grams",
            "20-25 grams",
            "Lunch (non veg)",
            R.raw.image45
        )
    )
    foodItems.add(
        FoodItem(
            "Egg Curry",
            "200-300 kcal",
            "15-20 grams",
            "5-10 grams",
            "12-15 grams",
            "Lunch (non veg)",
            R.raw.image46
        )
    )
    foodItems.add(
        FoodItem(
            "Chicken Fry",
            "250-350 kcal",
            "20-25 grams",
            "5-10 grams",
            "15-20 grams",
            "Lunch (non veg)",
            R.raw.image47
        )
    )
    foodItems.add(
        FoodItem(
            "Fish Fry",
            "200-300 kcal",
            "15-20 grams",
            "5-10 grams",
            "12-15 grams",
            "Lunch (non veg)",
            R.raw.image48
        )
    )
    foodItems.add(
        FoodItem(
            "Prawn Masala",
            "200-300 kcal",
            "15-20 grams",
            "5-10 grams",
            "12-15 grams",
            "Lunch (non veg)",
            R.raw.image49
        )
    )

    foodItems.add(
        FoodItem(
            "Milk (Whole)",
            "146",
            "7.7g",
            "11.7g",
            "7.9g",
            "Snacks: Liquid-based Food",
            R.raw.image20
        )
    )
    foodItems.add(
        FoodItem(
            "Orange Juice (unsweetened)",
            "110 kcal",
            "2 grams",
            "26 grams",
            "0.5 grams",
            "Snacks: Liquid-based Food",
            R.raw.image21
        )
    )
    foodItems.add(
        FoodItem(
            "Apple Juice (unsweetened)",
            "114 kcal",
            "0.3 grams",
            "28 grams",
            "0.4 grams",
            "Snacks: Liquid-based Food",
            R.raw.image22
        )
    )
    foodItems.add(
        FoodItem(
            "Grape Juice (unsweetened)",
            "154 kcal",
            "1.1 grams",
            "38 grams",
            "0.4 grams",
            "Snacks: Liquid-based Food",
            R.raw.image23
        )
    )
    foodItems.add(
        FoodItem(
            "Carrot Juice (unsweetened)",
            "94 kcal",
            "2 grams",
            "22 grams",
            "0.4 grams",
            "Snacks: Liquid-based Food",
            R.raw.image24
        )
    )
    foodItems.add(FoodItem("Apple (1 cup slices)", "57", "0.3g", "15.1g", "0.3g", "Fruits",R.raw.image25))
    foodItems.add(FoodItem("Banana (1 cup sliced)", "134", "1.6g", "34.3g", "0.5g", "Fruits",R.raw.image26))
    foodItems.add(FoodItem("Orange (1 cup sections)", "85", "1.7g", "21g", "0.2g", "Fruits",R.raw.image27))
    foodItems.add(FoodItem("Strawberries (1 cup whole)", "49", "1g", "11.7g", "0.5g", "Fruits",R.raw.image28))
    foodItems.add(FoodItem("Grapes (1 cup)", "104", "1.1g", "27.3g", "0.2g", "Fruits",R.raw.image23))
    foodItems.add(FoodItem("Spinach (1 cup cooked)", "41", "5.4g", "6.8g", "0.5g", "Vegetables",R.raw.image10))
    foodItems.add(FoodItem("Broccoli (1 cup chopped)", "55", "4.3g", "11.2g", "0.6g", "Vegetables",R.raw.image11))
    foodItems.add(FoodItem("Carrots (1 cup chopped)", "52", "1.2g", "12.3g", "0.3g", "Vegetables",R.raw.image12))
    foodItems.add(FoodItem("Tomatoes (1 cup chopped)", "32", "1.6g", "7.2g", "0.4g", "Vegetables",R.raw.image13))
    foodItems.add(
        FoodItem(
            "Bell Peppers (1 cup chopped)",
            "46",
            "1.5g",
            "9g",
            "0.4g",
            "Vegetables",R.raw.image14
        )
    )

    foodItems.add(FoodItem("Walnuts", "183", "4g", "4g", "18g", "Dry Fruits",R.raw.image16))
    foodItems.add(FoodItem("Cashews", "157", "5g", "9g", "12g", "Dry Fruits",R.raw.image1))
    foodItems.add(FoodItem("Pistachios", "156", "6g", "8g", "13g", "Dry Fruits",R.raw.image15))
    foodItems.add(FoodItem("Peanuts", "161", "7g", "5g", "14g", "Dry Fruits",R.raw.image19))
    foodItems.add(FoodItem("Raisins", "85", "1g", "22g", "0g", "Dry Fruits",R.raw.image18))
    foodItems.add(FoodItem("Dates", "23", "0.2g", "6g", "0g", "Dry Fruits",R.raw.image17))
    foodItems.add(
        FoodItem(
            "Kidney Beans (1 Cup boiled)",
            "225",
            "15.3g",
            "40.4g",
            "<1g",
            "Gram Dals",R.raw.image2
        )
    )
    foodItems.add(FoodItem("Chickpeas (1 Cup boiled)", "269", "14.5g", "45g", "4.25g", "Gram Dals",R.raw.image3))
    foodItems.add(FoodItem("Peas (1 Cup boiled)", "134", "8.6g", "25g", "4.25g", "Gram Dals",R.raw.image4))
    foodItems.add(
        FoodItem(
            "Chapati (1 medium-sized)",
            "70-80",
            "2-3 grams",
            "15-20 grams",
            "0.5-1 gram",
            "Dinner",R.raw.image5
        )
    )
    foodItems.add(
        FoodItem(
            "Parotta (1 medium-sized)",
            "200-250",
            "4-6 grams",
            "25-30 grams",
            "10-15 grams",
            "Dinner",R.raw.image7
        )
    )
    foodItems.add(
        FoodItem(
            "Roti (1 medium-sized)",
            "60-80",
            "2-3 grams",
            "10-15 grams",
            "1-2 grams",
            "Dinner",R.raw.image6
        )
    )
    foodItems.add(
        FoodItem(
            "Paneer (1 cup, diced)",
            "220-250",
            "20-25 grams",
            "3-5 grams",
            "14-18 grams",
            "Dinner",R.raw.image9
        )
    )
    return foodItems
}