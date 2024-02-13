package com.example.veterinariaheylen.Models.Querys

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class ControlQuery(
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "nameM") val nameM:String,
    @ColumnInfo(name = "nameV") val nameV:String
)
