package com.sanket.extraedge.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getDao():AppDao

    companion object{
        private var dbINSTANCE: AppDatabase? = null

        fun getAppDB(context: Context): AppDatabase{
            if (dbINSTANCE == null){
                dbINSTANCE = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "EEDB"
                ).allowMainThreadQueries().build()
            }
            return dbINSTANCE!!
        }
    }

}