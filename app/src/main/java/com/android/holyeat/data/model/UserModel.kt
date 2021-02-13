package com.android.holyeat.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class UserModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "year")
    val age: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sex")
    val sex: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "growth")
    var growth: Int,
    @ColumnInfo(name = "weight")
    var weight: Int,
    val photo: String
):Parcelable