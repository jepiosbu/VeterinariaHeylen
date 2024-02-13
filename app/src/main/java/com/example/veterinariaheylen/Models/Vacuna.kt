package com.example.veterinariaheylen.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vacuna")
data class Vacuna(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "nameV") val nameV:String
)