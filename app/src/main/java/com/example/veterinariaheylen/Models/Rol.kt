package com.example.veterinariaheylen.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rol")
data class Rol(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "nameR") val nameR:String
)
