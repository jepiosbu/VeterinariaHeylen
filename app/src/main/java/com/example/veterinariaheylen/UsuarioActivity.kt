package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.Adapters.AdapterUsuario
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.databinding.ActivityUsuarioBinding

class UsuarioActivity : AppCompatActivity() {
    lateinit var binding : ActivityUsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
    }
    fun llenar(){
        var data=database.daoUsuario().getQuery()
        binding.recycler.adapter = AdapterUsuario(data)
    }
}