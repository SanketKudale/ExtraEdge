package com.sanket.extraedge.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

object Constant {
    const val ROCKET_TABLE = "tableRocketList"
}

@Entity(tableName = Constant.ROCKET_TABLE)
class RocketEntity(


    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String = "temp",

    @ColumnInfo(name = "name")
    val name: String? = "",

    @ColumnInfo(name = "country")
    val country: String? = "",

    @ColumnInfo(name = "engines")
    val engines: Double? = 0.0,

    @ColumnInfo(name = "images")
    val images: ArrayList<String>? = ArrayList(),

    @ColumnInfo(name = "active")
    val active: Boolean? = false,

    @ColumnInfo(name = "costLaunch")
    val costLaunch: Double? = 0.0,

    @ColumnInfo(name = "success")
    val success: Double? = 0.0,

    @ColumnInfo(name = "description")
    val description: String? = "",

    @ColumnInfo(name = "wikipedia")
    val wikipedia: String? = "",

    @ColumnInfo(name = "height")
    val height: Double? = 0.0,

    @ColumnInfo(name = "diameter")
    val diameter: Double? = 0.0,

    @ColumnInfo(name = "detailsSet")
    val detailsSet: Boolean? = false
)