package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.Adapters.AdapterMascota
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.databinding.ActivityMascotaBinding
import com.example.veterinariaheylen.databinding.ActivityRmascotaBinding

class MascotaActivity : AppCompatActivity() {
    lateinit var binding: ActivityMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
    }

    fun llenar(){
        var data = database.daoMascota().getQuery()
        binding.recycler.adapter = AdapterMascota(data)
    }

}