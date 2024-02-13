package com.example.veterinariaheylen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.databinding.ActivityRegistrarBinding

class RegistrarActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        options()
    }
    fun options(){
        binding.Rvacuna.setOnClickListener {
            startActivity(Intent(this,RvacunaActivity::class.java))
        }
        binding.Rrol.setOnClickListener {
            startActivity(Intent(this,RrolActivity::class.java))
        }
        binding.Rtmascota.setOnClickListener {
            startActivity(Intent(this,RtmascotaActivity::class.java))
        }
        binding.Rusuario.setOnClickListener {
            startActivity(Intent(this,RusuarioActivity::class.java))
        }
        binding.Rmascota.setOnClickListener {
            startActivity(Intent(this,RmascotaActivity::class.java))
        }
        binding.Rcontrol.setOnClickListener {
            startActivity(Intent(this,RcontrolActivity::class.java))
        }
    }
}