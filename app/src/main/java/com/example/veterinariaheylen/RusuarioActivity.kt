package com.example.veterinariaheylen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Usuario
import com.example.veterinariaheylen.databinding.ActivityRusuarioBinding

class RusuarioActivity : AppCompatActivity() {
    lateinit var binding : ActivityRusuarioBinding
    var data : MutableList<String> = mutableListOf()
    var iddata : MutableList<Int> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRusuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spin()
        Save()
    }

    fun spin(){
        var list = database.daoRol().get()
        list.forEach {
            data.add(it.nameR)
            iddata.add(it.id)
        }
        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
        binding.spin.adapter = adapter
    }

    fun Save(){
        binding.save.setOnClickListener {
            try {
                var data=Usuario(0,binding.name.text.toString(),binding.usuario.text.toString(),
                    binding.password.text.toString(),iddata[binding.spin.selectedItemPosition])
                database.daoUsuario().post(data)
                Toast.makeText(this, "Guardado Exitoso", Toast.LENGTH_SHORT).show()
                finish()
            }
            catch (e:Error)
            {
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }
}