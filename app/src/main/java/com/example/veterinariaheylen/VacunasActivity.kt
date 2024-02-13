package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.Adapters.AdapterVacuna
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.databinding.ActivityVacunasBinding

class VacunasActivity : AppCompatActivity() {
    lateinit var binding: ActivityVacunasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVacunasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
    }

    fun llenar(){
        var tabla = database.daoVacuna().get()
        binding.recycler.adapter = AdapterVacuna(tabla)
    }

}