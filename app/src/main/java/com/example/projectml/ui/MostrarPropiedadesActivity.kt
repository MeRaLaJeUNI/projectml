package com.example.projectml.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectml.databinding.ActivityMostrarPropiedadesBinding

class MostrarPropiedadesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMostrarPropiedadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarPropiedadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Aquí puedes implementar la lógica para mostrar las propiedades en formato de tabla o lista
    }
}
