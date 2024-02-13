package com.example.veterinariaheylen.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinariaheylen.MainActivity
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Rol
import com.example.veterinariaheylen.RolesActivity
import com.example.veterinariaheylen.VacunasActivity
import com.example.veterinariaheylen.databinding.AdapterVacunasBinding

class AdapterRol(val rol:List<Rol>): RecyclerView.Adapter<AdapterRol.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterVacunasBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(rol[position])
    }


    override fun getItemCount(): Int {
        return rol.size
    }

    class ViewHolder(private val binding: AdapterVacunasBinding): RecyclerView.ViewHolder(binding.root){
        fun bin(rol: Rol){
            binding.rid.setText(rol.id.toString())
            binding.rname.setText(rol.nameR)

            binding.editar.setOnClickListener {
                binding.rname.isEnabled = true
                binding.guardar.layoutParams.width = 160;
                binding.guardar.requestLayout()
                binding.guardar.text = "Guardar"
            }

            binding.guardar.setOnClickListener {
                binding.rname.isEnabled = false
                binding.guardar.layoutParams.width = 0;
                binding.guardar.requestLayout()
                binding.guardar.text = ""
                var update = Rol(rol.id,binding.rname.text.toString())
                database.daoRol().update(update)
            }

            binding.eliminar.setOnClickListener {
                database.daoRol().delete(rol)
                itemView.context.startActivity(
                    Intent(itemView.context,
                        RolesActivity::class.java)
                )
                (itemView.context as Activity).finish()
            }
        }
    }
}