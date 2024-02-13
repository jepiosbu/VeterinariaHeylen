package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Vacuna
import com.example.veterinariaheylen.databinding.ActivityRegistrarBinding
import com.example.veterinariaheylen.databinding.ActivityRvacunaBinding

class RvacunaActivity : AppCompatActivity() {
    lateinit var binding: ActivityRvacunaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvacunaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Save()
    }

    fun Save(){
        binding.save.setOnClickListener {
            try {
                var vacuna= Vacuna(0,binding.name.text.toString())
                database.daoVacuna().post(vacuna)
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
                finish()
            }
            catch (e:Error){
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}