package com.example.veterinariaheylen.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Mascota",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id"],
            childColumns = ["usuario_id"]
        ),
        ForeignKey(
            entity = Tmascota::class,
            parentColumns = ["id"],
            childColumns = ["tmascota_id"]
        )
    ]
)
data class Mascota(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "nameM") val nameM:String,
    @ColumnInfo(name = "edad") val edad:Int,
    @ColumnInfo(name = "usuario_id") val usuario_id:Int,
    @ColumnInfo(name = "tmascota_id") val tmascota_id:Int

)
