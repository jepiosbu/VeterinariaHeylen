package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Rol
import com.example.veterinariaheylen.databinding.ActivityRrolBinding

class RrolActivity : AppCompatActivity() {
    lateinit var binding: ActivityRrolBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRrolBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Save()
    }

    fun Save(){
        binding.save.setOnClickListener {
            try {
                var datos = Rol(0,binding.name.text.toString())
                database.daoRol().post(datos)
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
                finish()
            }
            catch (e:Error){
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}