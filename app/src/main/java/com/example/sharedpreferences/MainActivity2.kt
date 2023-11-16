package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.sharedpreferences.SharedPreferences.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    private fun initUI(){
        binding.cerrarSesion.setOnClickListener{
            prefs.wipe()
            onBackPressedDispatcher.onBackPressed()
        }
        val username = prefs.getName()
        if (username.isNotEmpty()) {
            val textoBienvenida = "Bienvenida $username"
            binding.textoBienvenida.text = textoBienvenida
        }


        if(prefs.getVip()){
            setVipColorBackground()

        }
    }
    private fun setVipColorBackground(){
        binding.container.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow))


    }
}
