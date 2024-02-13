package com.example.veterinariaheylen.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tmascota")
data class Tmascota(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "nameT") val nameT:String
)
