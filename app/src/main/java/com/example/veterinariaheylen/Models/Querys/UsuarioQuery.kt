package com.example.veterinariaheylen.Models.Querys

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class UsuarioQuery(
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "nameU") val nameU:String,
    @ColumnInfo(name = "correo") val correo:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "nameR") val nameR:String
)