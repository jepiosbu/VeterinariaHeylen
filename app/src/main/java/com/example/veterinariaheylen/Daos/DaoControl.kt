package com.example.veterinariaheylen.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinariaheylen.Models.Control
import com.example.veterinariaheylen.Models.Mascota
import com.example.veterinariaheylen.Models.Querys.ControlQuery
import com.example.veterinariaheylen.Models.Querys.MascotaQuery

@Dao
interface DaoControl {
    @Query("SELECT * FROM Control")
    fun get():List<Control>

    @Query("SELECT Control.id, Mascota.nameM, Vacuna.nameV FROM Control JOIN Mascota ON Control.mascota_id = Mascota.id JOIN Vacuna ON Control.vacuna_id = Vacuna.id")
    fun getQuery():List<ControlQuery>
    @Insert
    fun post(control: Control)

    @Update
    fun update(control: Control)

    @Delete
    fun delete(control: Control)
}