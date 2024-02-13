package com.example.veterinariaheylen.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Vacuna
import com.example.veterinariaheylen.VacunasActivity
import com.example.veterinariaheylen.databinding.AdapterVacunasBinding


class AdapterVacuna(val vacuna:List<Vacuna>):RecyclerView.Adapter<AdapterVacuna.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterVacunasBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(vacuna[position])
    }

    override fun getItemCount(): Int {
        return vacuna.size
    }

    class ViewHolder(private val binding: AdapterVacunasBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(vacuna:Vacuna){
            binding.rid.setText(vacuna.id.toString())
            binding.rname.setText(vacuna.nameV)

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
                var update = Vacuna(vacuna.id,binding.rname.text.toString())
                database.daoVacuna().update(update)
            }

            binding.eliminar.setOnClickListener {
                database.daoVacuna().delete(vacuna)
                (itemView.context as Activity).finish()
                itemView.context.startActivity(Intent(itemView.context,VacunasActivity::class.java))
            }
        }
    }
}