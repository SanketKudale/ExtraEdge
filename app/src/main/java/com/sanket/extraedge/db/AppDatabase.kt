package com.sanket.extraedge.db

import androidx.room.*
import com.sanket.extraedge.utils.Converters

@Database(entities = [RocketEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun appDao():AppDao

}