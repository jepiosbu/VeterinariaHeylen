package com.example.veterinariaheylen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.veterinariaheylen.databinding.ActivityRegistrosBinding

class RegistrosActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegistrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        option()
    }

    fun option(){
        binding.Vacuna.setOnClickListener {
            startActivity(Intent(this,VacunasActivity::class.java))
        }
        binding.Rol.setOnClickListener {
            startActivity(Intent(this,RolesActivity::class.java))
        }
        binding.Tmascota.setOnClickListener {
            startActivity(Intent(this,TmascotaActivity::class.java))
        }
        binding.Usuario.setOnClickListener {
            startActivity(Intent(this,UsuarioActivity::class.java))
        }
        binding.Mascota.setOnClickListener {
            startActivity(Intent(this,MascotaActivity::class.java))
        }
        binding.Control.setOnClickListener {
            startActivity(Intent(this,ControlActivity::class.java))
        }
    }
}