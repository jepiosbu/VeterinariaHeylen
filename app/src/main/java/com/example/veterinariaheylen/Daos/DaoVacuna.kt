package com.example.veterinariaheylen.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinariaheylen.Models.Vacuna

@Dao
interface DaoVacuna {

    @Query("SELECT * FROM Vacuna")
    fun get():List<Vacuna>

    @Insert
    fun post(vacuna:Vacuna)

    @Update
    fun update(vacuna:Vacuna)

    @Delete
    fun delete(vacuna:Vacuna)

}