package com.sanket.extraedge.db

import javax.inject.Inject

class RoomRepo @Inject constructor(private val appDao: AppDao) {

    fun getRockets(): List<RocketEntity> {
        return appDao.getRockets()
    }

    fun getRocketDetails(id: String): RocketEntity {
        return appDao.getRocketDetails(id)
    }

    fun saveRocket(rocketEntity: RocketEntity) {
        return appDao.saveRocket(rocketEntity)
    }

}
