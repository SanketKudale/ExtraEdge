package com.sanket.extraedge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sanket.extraedge.model.Rocket

@Dao
interface AppDao {

    @Query("SELECT * FROM tableRocketList")
    fun getRockets(): ArrayList<Rocket>

    @Query("SELECT * FROM tableRocketDetails WHERE id = :rocketId")
    fun getRocketDetails(rocketId: String): ArrayList<Rocket>

    @Insert
    fun saveRockets(rocketListEntity: RocketListEntity)

    @Insert
    fun saveRocketDetails(rocketDetailsEntity: RocketDetailsEntity)
}