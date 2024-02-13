package com.example.veterinariaheylen.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinariaheylen.MainActivity.Companion.database
import com.example.veterinariaheylen.Models.Querys.UsuarioQuery
import com.example.veterinariaheylen.Models.Usuario
import com.example.veterinariaheylen.UsuarioActivity
import com.example.veterinariaheylen.databinding.AdapterUsuarioBinding

class AdapterUsuario(val usuario:List<UsuarioQuery>):RecyclerView.Adapter<AdapterUsuario.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterUsuarioBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(usuario[position])
    }

    override fun getItemCount(): Int {
        return usuario.size
    }

    class ViewHolder(private val binding:AdapterUsuarioBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(usuario : UsuarioQuery){
            var list= mutableListOf<String>()
            var listid= mutableListOf<Int>()
            var data = database.daoRol().get()
            data.forEach {
                list.add(it.nameR)
                listid.add(it.id)
            }
            var adapter = ArrayAdapter(itemView.context,android.R.layout.simple_list_item_1,list)
            binding.spinner.adapter = adapter
            binding.rid.setText(usuario.id.toString())
            binding.rname.setText(usuario.nameU)
            binding.rcorreo.setText(usuario.correo)
            binding.rpassword.setText(usuario.password)
            binding.rrol.setText(usuario.nameR)
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
                var update = Usuario(usuario.id,binding.Ename.text.toString(),
                    binding.Ecorreo.text.toString(),binding.Epassword.text.toString(),
                    listid[binding.spinner.selectedItemPosition])
                database.daoUsuario().update(update)
                (itemView.context as Activity).finish()
                itemView.context.startActivity(Intent(itemView.context,UsuarioActivity::class.java))
            }
            binding.eliminar.setOnClickListener {
                var delete = Usuario(usuario.id,"","","",0)
                database.daoUsuario().delete(delete)
                (itemView.context as Activity).finish()
                itemView.context.startActivity(Intent(itemView.context,UsuarioActivity::class.java))
            }
        }
    }
}