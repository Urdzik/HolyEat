package com.android.holyeat.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sex")
    val sex: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "growth")
    val growth: Int,
    @ColumnInfo(name = "weight")
    val weight: Int
)