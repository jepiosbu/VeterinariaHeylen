package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.Adapters.AdapterControl
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.databinding.ActivityControlBinding

class ControlActivity : AppCompatActivity() {
    lateinit var binding: ActivityControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
    }
    fun llenar(){
        var data = database.daoControl().getQuery()
        binding.recycler.adapter = AdapterControl(data)
    }
}