package com.example.veterinariaheylen

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Control
import com.example.veterinariaheylen.Models.Mascota
import com.example.veterinariaheylen.databinding.ActivityRcontrolBinding

class RcontrolActivity : AppCompatActivity() {
    lateinit var binding : ActivityRcontrolBinding
    var masid = mutableListOf<Int>()
    var masname = mutableListOf<String>()
    var vacuid = mutableListOf<Int>()
    var vacuname = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRcontrolBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        Save()
    }
    fun llenar(){
        var data = database.daoMascota().get()
        data.forEach {
            masid.add(it.id)
            masname.add(it.nameM)
        }
        var data1= MainActivity.database.daoVacuna().get()
        data1.forEach {
            vacuid.add(it.id)
            vacuname.add(it.nameV)
        }
        var adapterM= ArrayAdapter(this, R.layout.simple_list_item_1,masname)
        binding.spiM.adapter = adapterM
        var adapterV= ArrayAdapter(this, R.layout.simple_list_item_1,vacuname)
        binding.spiV.adapter = adapterV
    }
    fun Save(){
        binding.save.setOnClickListener {
            try {
                var save = Control(0,masid[binding.spiM.selectedItemPosition],vacuid[binding.spiV.selectedItemPosition])
                database.daoControl().post(save)
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