package com.example.veterinariaheylen.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinariaheylen.Models.Mascota
import com.example.veterinariaheylen.Models.Querys.MascotaQuery

@Dao
interface DaoMascota {
    @Query("SELECT * FROM Mascota")
    fun get():List<Mascota>

    @Query("SELECT Mascota.id,Mascota.nameM,Mascota.edad,Usuario.nameU,Tmascota.nameT FROM Mascota JOIN Usuario ON Mascota.usuario_id = Usuario.id JOIN Tmascota ON Mascota.tmascota_id = Tmascota.id")
    fun getQuery():List<MascotaQuery>

    @Insert
    fun post(mascota: Mascota)

    @Update
    fun update(mascota: Mascota)

    @Delete
    fun delete(mascota: Mascota)
}