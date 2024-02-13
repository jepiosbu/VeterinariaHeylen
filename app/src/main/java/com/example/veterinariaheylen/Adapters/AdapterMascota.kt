package com.example.veterinariaheylen.Adapters

import android.R
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinariaheylen.MainActivity
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.MascotaActivity
import com.example.veterinariaheylen.Models.Mascota
import com.example.veterinariaheylen.Models.Querys.MascotaQuery
import com.example.veterinariaheylen.UsuarioActivity
import com.example.veterinariaheylen.databinding.AdapterMascotaBinding

class AdapterMascota(val mascota:List<MascotaQuery>):RecyclerView.Adapter<AdapterMascota.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterMascotaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(mascota[position])
    }

    override fun getItemCount(): Int {
        return  mascota.size
    }

    class ViewHolder(private val binding : AdapterMascotaBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(mascota: MascotaQuery){
                var list= mutableListOf<String>()
                var listid= mutableListOf<Int>()
                var list2= mutableListOf<String>()
                var listid2= mutableListOf<Int>()
                var data = MainActivity.database.daoUsuario().get()
                var data2 = MainActivity.database.daoTmascota().get()
                data.forEach {
                    list.add(it.nameU)
                    listid.add(it.id)
                }
                data2.forEach {
                    list2.add(it.nameT)
                    listid2.add(it.id)
                }
                var adapter = ArrayAdapter(itemView.context, R.layout.simple_list_item_1,list)
                binding.Epassword.adapter = adapter
                var adapter2 = ArrayAdapter(itemView.context, R.layout.simple_list_item_1,list2)
                binding.spinner.adapter = adapter2
                binding.rid.setText(mascota.id.toString())
                binding.rname.setText(mascota.nameM)
                binding.rcorreo.setText(mascota.edad.toString())
                binding.rpassword.setText(mascota.nameU)
                binding.rrol.setText(mascota.nameT)
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
                    var update = Mascota(mascota.id,binding.Ename.text.toString(),
                        binding.Ecorreo.text.toString().toInt(),listid[binding.Epassword.selectedItemPosition],
                        listid2[binding.spinner.selectedItemPosition])
                    database.daoMascota().update(update)
                    (itemView.context as Activity).finish()
                    itemView.context.startActivity(
                        Intent(itemView.context,
                            MascotaActivity::class.java)
                    )
                }
                binding.eliminar.setOnClickListener {
                    var delete = Mascota(mascota.id,"",0,0,0)
                    database.daoMascota().delete(delete)
                    (itemView.context as Activity).finish()
                    itemView.context.startActivity(
                        Intent(itemView.context,
                            MascotaActivity::class.java)
                    )
                }
        }
    }
}