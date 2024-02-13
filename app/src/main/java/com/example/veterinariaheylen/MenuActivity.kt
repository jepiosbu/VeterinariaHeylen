package com.example.veterinariaheylen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    lateinit var binding : ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        options()
    }

    fun options(){
        binding.registrar.setOnClickListener {
            startActivity(Intent(this,RegistrarActivity::class.java))
        }

        binding.registros.setOnClickListener {
            startActivity(Intent(this,RegistrosActivity::class.java))
        }
    }

}