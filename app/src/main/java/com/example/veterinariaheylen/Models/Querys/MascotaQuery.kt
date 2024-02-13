package com.example.veterinariaheylen.Models.Querys

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class MascotaQuery(
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "nameM") val nameM:String,
    @ColumnInfo(name = "edad") val edad:Int,
    @ColumnInfo(name = "nameU") val nameU:String,
    @ColumnInfo(name = "nameT") val nameT:String
)
