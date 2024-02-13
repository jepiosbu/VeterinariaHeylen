package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.Adapters.AdapterTmascota
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.databinding.ActivityTmascotaBinding

class TmascotaActivity : AppCompatActivity() {
    lateinit var binding : ActivityTmascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
    }
    fun llenar(){
        var data = database.daoTmascota().get()
        binding.recycler.adapter = AdapterTmascota(data)
    }
}