package com.example.veterinariaheylen.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Tmascota
import com.example.veterinariaheylen.TmascotaActivity
import com.example.veterinariaheylen.databinding.AdapterTmascotaBinding

class AdapterTmascota(val tmascota: List<Tmascota>):RecyclerView.Adapter<AdapterTmascota.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterTmascotaBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(tmascota[position])
    }

    override fun getItemCount(): Int {
        return tmascota.size
    }

    class ViewHolder(private val binding: AdapterTmascotaBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(tmascota: Tmascota){
            binding.id.text = tmascota.id.toString()
            binding.rname.setText(tmascota.nameT)

            binding.editar.setOnClickListener {
                binding.rname.isEnabled = true
                binding.guardar.layoutParams.width=160
                binding.guardar.text = "Guadar"
                binding.guardar.requestLayout()
            }

            binding.guardar.setOnClickListener {
                binding.rname.isEnabled = false
                binding.guardar.layoutParams.width=0
                binding.guardar.text = ""
                binding.guardar.requestLayout()
                var update=Tmascota(tmascota.id,binding.rname.text.toString())
                database.daoTmascota().update(update)
            }

            binding.eliminar.setOnClickListener {
                database.daoTmascota().delete(tmascota)
                (itemView.context as Activity).finish()
                itemView.context.startActivity(Intent(itemView.context,TmascotaActivity::class.java))
            }
        }
    }
}