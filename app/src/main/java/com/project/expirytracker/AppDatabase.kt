package com.project.expirytracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [DatabaseModel::class],version=1, exportSchema = false)
public abstract class AppDatabase:RoomDatabase() {


    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            INSTANCE?.let {
                return it
            }

            return synchronized(AppDatabase::class.java){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "expiry_app_db"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }
}