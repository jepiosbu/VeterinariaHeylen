package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.Adapters.AdapterRol
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.databinding.ActivityRolesBinding

class RolesActivity : AppCompatActivity() {
    lateinit var binding : ActivityRolesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRolesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
    }
    fun llenar(){
        var datos=database.daoRol().get()
        binding.recycler.adapter = AdapterRol(datos)
    }
}