package com.project.dietively.util

import com.project.dietively.R
import com.project.dietively.roomdb.FoodItem


fun getFoodItemList(): ArrayList<FoodItem> {

    val foodItems = arrayListOf<FoodItem>()
    foodItems.add(
        FoodItem(
            "Idly",
            "30g",
            "2g",
            "1g",
            "30 calories",
            "Breakfast",
            R.raw.image30
        )
    )
    foodItems.add(
        FoodItem(
            "Dosa",
            "18mg",
            "2g",
            "2g",
            "115 calories",
            "Breakfast",
            R.raw.image32
        )
    )
    foodItems.add(
        FoodItem(
            "Upma",
            "38mg",
            "3g",
            "2g",
            "100 calories",
            "Breakfast",
            R.raw.image31
        )
    )
    foodItems.add(
        FoodItem(
            "Pongal",
            "40mg",
            "4g",
            "2g",
            "200 kcal",
            "Breakfast",
            R.raw.image34
        )
    )
    foodItems.add(
        FoodItem(
            "Poori",
            "3mg",
            "1g",
            "4g",
            "100 calories",
            "Breakfast",
            R.raw.image33
        )
    )
    foodItems.add(
        FoodItem(
            "Puttu",
            "17mg",
            "3.5g",
            "1.5g",
            "180 kcal",
            "Breakfast",
            R.raw.image36
        )
    )
    foodItems.add(
        FoodItem(
            "Idiyappam",
            "9mg",
            "3g",
            "1g",
            "60 kcal",
            "Breakfast",
            R.raw.image35
        )
    )
    foodItems.add(
        FoodItem(
            "Sambar Rice",
            "80 mg (about 1 cup)",
            "8g",
            "3g",
            "250 calories",
            "Lunch (veg)",
            R.raw.image38
        )
    )
    foodItems.add(
        FoodItem(
            "Rasam Rice",
            "30mg",
            "4g",
            "2g",
            "100 calories",
            "Lunch (veg)",
            R.raw.image37
        )
    )
    foodItems.add(
        FoodItem(
            "Lemon Rice",
            "30mg",
            "2g",
            "6g",
            "150 calories",
            "Lunch (veg)",
            R.raw.image41
        )
    )
    foodItems.add(
        FoodItem(
            "Tomato Rice",
            "7mg",
            "6g",
            "5g",
            "250 calories",
            "Lunch (veg)",
            R.raw.image39
        )
    )
    foodItems.add(
        FoodItem(
            "Curd Rice",
            "7mg",
            "7g",
            "10g",
            "250 calories",
            "Lunch (veg)",
            R.raw.image40
        )
    )
    foodItems.add(
        FoodItem(
            "Vegetable Biryani",
            "45mg",
            "7g",
            "15g",
            "350 kcal",
            "Lunch (veg)",
            R.raw.image42
        )
    )
    foodItems.add(
        FoodItem(
            "Chicken Biryani",
            "60mg",
            "15g",
            "20g",
            "400 calories",
            "Lunch (non veg)",
            R.raw.image43
        )
    )
    foodItems.add(
        FoodItem(
            "Fish Curry",
            "50mg",
            "25g",
            "20g",
            "250 calories",
            "Lunch (non veg)",
            R.raw.image44
        )
    )
    foodItems.add(
        FoodItem(
            "Mutton Curry",
            "30mg",
            "25g",
            "15g",
            "250 calories",
            "Lunch (non veg)",
            R.raw.image45
        )
    )
    foodItems.add(
        FoodItem(
            "Egg Curry",
            "100mg",
            "20g",
            "15g",
            "200 calories",

            "Lunch (non veg)",
            R.raw.image46
        )
    )
    foodItems.add(
        FoodItem(
            "Chicken Fry",
            "10mg",
            "25g",
            "15g",
            "250 kcal",
            "Lunch (non veg)",
            R.raw.image47
        )
    )
    foodItems.add(
        FoodItem(
            "Fish Fry",
            "20mg",
            "20g",
            "15g",
            "200 calories",
            "Lunch (non veg)",
            R.raw.image48
        )
    )
    foodItems.add(
        FoodItem(
            "Prawn Masala",
            "50mg",
            "20g",
            "15g",
            "200 calories",
            "Lunch (non veg)",
            R.raw.image49
        )
    )

    foodItems.add(
        FoodItem(
            "Milk (Whole)",
            "276mg",
            "8g",
            "8g",
            "149 calories",
            "Snacks: Liquid-based Food",
            R.raw.image20
        )
    )
    foodItems.add(
        FoodItem(
            "Orange Juice (unsweetened)",
            "24mg",
            "2g",
            "0g",
            "112",
            "Snacks: Liquid-based Food",
            R.raw.image21
        )
    )
    foodItems.add(
        FoodItem(
            "Apple Juice (unsweetened)",
            "3 mg",
            "1g",
            "1g",
            "115 calories",
            "Snacks: Liquid-based Food",
            R.raw.image22
        )
    )
    foodItems.add(
        FoodItem(
            "Grape Juice (unsweetened)",
            "15mg",
            "1g",
            "0g",
            "60",
            "Snacks: Liquid-based Food",
            R.raw.image23
        )
    )
    foodItems.add(
        FoodItem(
            "Carrot Juice (unsweetened)",
            "44 mg",
            "2g",
            "1g",
            "70 calories",
            "Snacks: Liquid-based Food",
            R.raw.image24
        )
    )
    foodItems.add(
        FoodItem(
            "Apple (1 cup slices)",
            "57",
            "0.3g",
            "15.1g",
            "0.3g",
            "Fruits",
            R.raw.image25
        )
    )
    foodItems.add(
        FoodItem(
            "Banana (1 cup sliced)",
            "134",
            "1.6g",
            "34.3g",
            "0.5g",
            "Fruits",
            R.raw.image26
        )
    )
    foodItems.add(
        FoodItem(
            "Orange (1 cup sections)",
            "85",
            "1.7g",
            "21g",
            "0.2g",
            "Fruits",
            R.raw.image27
        )
    )
    foodItems.add(
        FoodItem(
            "Strawberries (1 cup whole)",
            "49",
            "1g",
            "11.7g",
            "0.5g",
            "Fruits",
            R.raw.image28
        )
    )
    foodItems.add(
        FoodItem(
            "Grapes (1 cup)",
            "104",
            "1.1g",
            "27.3g",
            "0.2g",
            "Fruits",
            R.raw.image29
        )
    )
    foodItems.add(
        FoodItem(
            "Spinach (1 cup cooked)",
            "41mg",
            "5.4g",
            "6.8g",
            "0.5g",
            "Vegetables",
            R.raw.image10
        )
    )
    foodItems.add(
        FoodItem(
            "Broccoli (1 cup chopped)",
            "55mg",
            "4.3g",
            "11.2g",
            "0.6g",
            "Vegetables",
            R.raw.image11
        )
    )
    foodItems.add(
        FoodItem(
            "Carrots (1 cup chopped)",
            "52",
            "1.2g",
            "12.3g",
            "0.3g",
            "Vegetables",
            R.raw.image12
        )
    )
    foodItems.add(
        FoodItem(
            "Tomatoes (1 cup chopped)",
            "32",
            "1.6g",
            "7.2g",
            "0.4g",
            "Vegetables",
            R.raw.image13
        )
    )
    foodItems.add(
        FoodItem(
            "Bell Peppers (1 cup chopped)",
            "46",
            "1.5g",
            "9g",
            "0.4g",
            "Vegetables", R.raw.image14
        )
    )

    foodItems.add(FoodItem("Walnuts", "183", "4g", "18g","4g",  "Dry Fruits", R.raw.image16))
    foodItems.add(FoodItem("Cashews", "157", "5g", "12g","9g",  "Dry Fruits", R.raw.image17))
    foodItems.add(FoodItem("Pistachios", "156", "6g", "13g","8g",  "Dry Fruits", R.raw.image18))
    foodItems.add(FoodItem("Peanuts", "161", "7g", "14g","5g",  "Dry Fruits", R.raw.image19))
    foodItems.add(FoodItem("Raisins", "85", "1g",  "0g","22g", "Dry Fruits", R.raw.image1))
    foodItems.add(FoodItem("Dates", "23", "0.2g",  "0g","6g", "Dry Fruits", R.raw.image2))
    foodItems.add(
        FoodItem(
            "Kidney Beans (1 Cup boiled)",
            "225",
            "15.3g","1g",
            "40.4g",
            "Gram Dals", R.raw.image3
        )
    )
    foodItems.add(
        FoodItem(
            "Chickpeas (1 Cup boiled)",
            "269",
            "14.5g",
            "45g",
            "4.25g",
            "Gram Dals",
            R.raw.image4
        )
    )
    foodItems.add(
        FoodItem(
            "Peas (1 Cup boiled)",
            "134",
            "8.6g",
            "25g",
            "4.25g",
            "Gram Dals",
            R.raw.image5
        )
    )
    foodItems.add(
        FoodItem(
            "Chapati (1 medium-sized)",
            "10mg",
            "4g",
            "2g",
            "80 calories",
            "Dinner", R.raw.image6
        )
    )
    foodItems.add(
        FoodItem(
            "Parotta (1 medium-sized)",
            "20mg",
            "6g",
            "12g",
            "200 calories",
            "Dinner",
            R.raw.image7
        )
    )
    foodItems.add(
        FoodItem(
            "Roti (1 medium-sized)",
            "20mg",
            "3g",
            "1g",
            "70 calories",
            "Dinner", R.raw.image8
        )
    )
    foodItems.add(
        FoodItem(
            "Paneer (1 cup, diced)",
            "490 mg",
            "24g",
            "22g",
            "265 calories",
            "Dinner", R.raw.image9
        )
    )
    return foodItems
}
