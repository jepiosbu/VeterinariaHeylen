package com.example.veterinariaheylen.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinariaheylen.Models.Querys.UsuarioQuery
import com.example.veterinariaheylen.Models.Usuario

@Dao
interface DaoUsuario {
    @Query("SELECT * FROM Usuario")
    fun get():List<Usuario>

    @Query("SELECT Usuario.id,Usuario.nameU,Usuario.correo,Usuario.password,Rol.nameR FROM Usuario JOIN Rol ON Usuario.rol_id = Rol.id")
    fun getQuery():List<UsuarioQuery>

    @Insert
    fun post(usuario: Usuario)

    @Update
    fun update(usuario: Usuario)

    @Delete
    fun delete(usuario: Usuario)
}