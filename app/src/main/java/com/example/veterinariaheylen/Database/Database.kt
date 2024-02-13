package com.example.veterinariaheylen.Database

import android.provider.ContactsContract.RawContacts.Data
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.veterinariaheylen.Daos.DaoControl
import com.example.veterinariaheylen.Daos.DaoMascota
import com.example.veterinariaheylen.Daos.DaoRol
import com.example.veterinariaheylen.Daos.DaoTmascota
import com.example.veterinariaheylen.Daos.DaoUsuario
import com.example.veterinariaheylen.Daos.DaoVacuna
import com.example.veterinariaheylen.Models.Control
import com.example.veterinariaheylen.Models.Mascota
import com.example.veterinariaheylen.Models.Rol
import com.example.veterinariaheylen.Models.Tmascota
import com.example.veterinariaheylen.Models.Usuario
import com.example.veterinariaheylen.Models.Vacuna

@Database(
    entities = [Vacuna::class, Rol::class,Tmascota::class,
                Usuario::class, Mascota::class,Control::class],
    version = 1
)
abstract class Database():RoomDatabase() {

    abstract fun daoVacuna() : DaoVacuna

    abstract fun daoRol() : DaoRol

    abstract fun daoTmascota() : DaoTmascota

    abstract fun daoUsuario() : DaoUsuario

    abstract fun daoMascota() : DaoMascota

    abstract fun daoControl() : DaoControl

}