package com.example.veterinariaheylen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.veterinariaheylen.Database.Database
import com.example.veterinariaheylen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    companion object{
        lateinit var database:Database
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = Room.databaseBuilder(this,Database::class.java,"veterinaria").allowMainThreadQueries().build()
        splahs()
    }

    fun splahs(){
        binding.splahs.animate().setDuration(4000).scaleX(1.5f).scaleY(1.5f).withEndAction {
            startActivity(Intent(this,MenuActivity::class.java))
        }
    }

}