package com.sanket.extraedge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM ${Constant.ROCKET_TABLE}")
    fun getRockets(): List<RocketEntity>

    @Query("Select * FROM ${Constant.ROCKET_TABLE} WHERE id =:id")
    fun getRocketDetails(id: String): RocketEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRocket(rocketEntity: RocketEntity)

}