package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Tmascota
import com.example.veterinariaheylen.databinding.ActivityRtmascotaBinding

class RtmascotaActivity : AppCompatActivity() {
    lateinit var binding : ActivityRtmascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRtmascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Save()
    }
    fun Save(){
        binding.save.setOnClickListener {
            try {
                var data = Tmascota(0,binding.name.text.toString())
                database.daoTmascota().post(data)
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
                finish()
            }
            catch (e:Error)
            {
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}