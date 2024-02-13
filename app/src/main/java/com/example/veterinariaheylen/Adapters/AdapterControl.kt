package com.example.veterinariaheylen.Adapters

import android.R
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinariaheylen.ControlActivity
import com.example.veterinariaheylen.MainActivity
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.MascotaActivity
import com.example.veterinariaheylen.Models.Control
import com.example.veterinariaheylen.Models.Mascota
import com.example.veterinariaheylen.Models.Querys.ControlQuery
import com.example.veterinariaheylen.databinding.AdapterControlBinding
import com.example.veterinariaheylen.databinding.AdapterMascotaBinding

class AdapterControl(val control:List<ControlQuery>):RecyclerView.Adapter<AdapterControl.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterControlBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(control[position])
    }

    override fun getItemCount(): Int {
        return control.size
    }

    class ViewHolder(private val binding : AdapterControlBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(control:ControlQuery){
            var list= mutableListOf<String>()
            var listid= mutableListOf<Int>()
            var list2= mutableListOf<String>()
            var listid2= mutableListOf<Int>()
            var data = MainActivity.database.daoMascota().get()
            var data2 = MainActivity.database.daoVacuna().get()
            data.forEach {
                list.add(it.nameM)
                listid.add(it.id)
            }
            data2.forEach {
                list2.add(it.nameV)
                listid2.add(it.id)
            }
            var adapter = ArrayAdapter(itemView.context, R.layout.simple_list_item_1,list)
            binding.Epassword.adapter = adapter
            var adapter2 = ArrayAdapter(itemView.context, R.layout.simple_list_item_1,list2)
            binding.spinner.adapter = adapter2
            binding.rid.setText(control.id.toString())
            binding.rname.setText(control.nameM)
            binding.rcorreo.setText(control.nameV)
            binding.editar.setOnClickListener {
                binding.adapter.layoutParams.height = 1500
                binding.adapter.requestLayout()
                binding.guardar.layoutParams.width = 160
                binding.guardar.text = "Guardar"
                binding.guardar.requestLayout()
            }
            binding.guardar.setOnClickListener{
                binding.adapter.layoutParams.height = 650
                binding.adapter.requestLayout()
                binding.guardar.layoutParams.width = 0
                binding.guardar.text = ""
                binding.guardar.requestLayout()
                var update = Control(control.id,listid[binding.Epassword.selectedItemPosition],
                    listid2[binding.spinner.selectedItemPosition])
                database.daoControl().update(update)
                (itemView.context as Activity).finish()
                itemView.context.startActivity(
                    Intent(itemView.context,
                        ControlActivity::class.java)
                )
            }
            binding.eliminar.setOnClickListener {
                var delete = Control(control.id,0,0,)
                database.daoControl().delete(delete)
                (itemView.context as Activity).finish()
                itemView.context.startActivity(
                    Intent(itemView.context,
                        ControlActivity::class.java)
                )
            }
        }
    }
}