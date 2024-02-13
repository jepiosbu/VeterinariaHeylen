package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Mascota
import com.example.veterinariaheylen.databinding.ActivityRmascotaBinding

class RmascotaActivity : AppCompatActivity() {
    lateinit var binding: ActivityRmascotaBinding
    var usuid = mutableListOf<Int>()
    var usuname = mutableListOf<String>()
    var tipoid = mutableListOf<Int>()
    var tiponame = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRmascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spiners()
        Save()
    }

    fun spiners(){
        var data = database.daoUsuario().get()
        data.forEach {
            usuid.add(it.id)
            usuname.add(it.nameU)
        }
        var data1= database.daoTmascota().get()
        data1.forEach {
            tipoid.add(it.id)
            tiponame.add(it.nameT)
        }
        var adapterU= ArrayAdapter(this,android.R.layout.simple_list_item_1,usuname)
        binding.spiU.adapter = adapterU
        var adapterT= ArrayAdapter(this,android.R.layout.simple_list_item_1,tiponame)
        binding.spiT.adapter = adapterT
    }

    fun Save(){
        binding.save.setOnClickListener {
            try {
                var save = Mascota(0,binding.name.text.toString(),binding.edad.text.toString().toInt(),
                    usuid[binding.spiU.selectedItemPosition],tipoid[binding.spiT.selectedItemPosition])
                database.daoMascota().post(save)
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