package com.sanket.extraedge.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableRocketList")
class RocketListEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") val uid: Int? = 0,
    @ColumnInfo(name = "id") val id: String? = "",
    @ColumnInfo(name = "name") val name: String? = "",
    @ColumnInfo(name = "country") val country: String? = "",
    @ColumnInfo(name = "engines") val engines: Double? = 0.0,
    @ColumnInfo(name = "images") val images: ArrayList<String>? = ArrayList()
)

@Entity(tableName = "tableRocketDetails")
class RocketDetailsEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") val uid: Int? = 0,
    @ColumnInfo(name = "name") val name: String? = "",
    @ColumnInfo(name = "active") val active: Boolean? = false,
    @ColumnInfo(name = "costLaunch") val costLaunch: Double? = 0.0,
    @ColumnInfo(name = "images") val images: ArrayList<String>? = ArrayList(),
    @ColumnInfo(name = "success") val success: Double? = 0.0,
    @ColumnInfo(name = "description") val description: String? = "",
    @ColumnInfo(name = "wikipedia") val wikipedia: String? = "",
    @ColumnInfo(name = "height") val height: Double? = 0.0,
    @ColumnInfo(name = "diameter") val diameter: Double? = 0.0,
)