package com.android.holyeat.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nutritionist")
data class  NutritionistModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "cost")
    val cost: Int,
    @ColumnInfo(name = "rank")
    val rank: String,
    @ColumnInfo(name = "rating")
    val rating: Float,
    @ColumnInfo(name = "image")
    val image: String

)
