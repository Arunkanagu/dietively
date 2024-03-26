package com.project.dietively.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [UserProfile::class,DailyData::class,FoodItem::class,MenstrualDays::class],
    version = 1,
    exportSchema = false
)

//@TypeConverters(SurveyQuesListTypeConverter::class, SurveyAnswerTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun databaseDao(): DatabaseDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "dietively_database"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}