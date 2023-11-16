package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.SharedPreferences.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initUI()
        checkUserValues()
    }

    private fun checkUserValues(){
        if (prefs.getName().isNotEmpty()){
            goToDetail()
        }

    }

    private fun initUI(){
        binding.botonContinuar.setOnClickListener{
            accesToDetail()

        }
    }

    private fun accesToDetail(){
        val editText = binding.inputNombre.text
        if (editText.toString().isNotEmpty()) {
            prefs.saveName(binding.inputNombre.text.toString())
            prefs.saveVIP(binding.inputBox.isChecked)
            goToDetail()

        }else{
            Toast.makeText(this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show()

        }

    }

    private fun goToDetail(){
        val intent=Intent(this,MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}
