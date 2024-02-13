package com.example.veterinariaheylen.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinariaheylen.Models.Rol
import com.example.veterinariaheylen.Models.Vacuna

@Dao
interface DaoRol {
    @Query("SELECT * FROM Rol")
    fun get():List<Rol>

    @Insert
    fun post(rol : Rol)

    @Update
    fun update(rol : Rol)

    @Delete
    fun delete(rol : Rol)
}