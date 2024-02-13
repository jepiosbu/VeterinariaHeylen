package com.example.veterinariaheylen.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinariaheylen.Models.Rol
import com.example.veterinariaheylen.Models.Tmascota

@Dao
interface DaoTmascota {
    @Query("SELECT * FROM Tmascota")
    fun get():List<Tmascota>

    @Insert
    fun post(rol : Tmascota)

    @Update
    fun update(rol : Tmascota)

    @Delete
    fun delete(rol : Tmascota)
}