package com.example.projectml.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectml.database.DatabaseHelper
import com.example.projectml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        // Muestra los datos predefinidos
        binding.textViewDatos.text = "Apellidos y Nombres: MERA LAJE JOSE ANDRES\nNombre de la Entidad Asignada: HOSPITAL\nCurso y Paralelo: Septimo A"

        // Configura el botón para ir a PropiedadesActivity
        binding.buttonAgregarPropiedades.setOnClickListener {
            val intent = Intent(this, PropiedadesActivity::class.java)
            startActivity(intent)
        }

        // Configura el botón para mostrar las propiedades en MostrarPropiedadesActivity
        binding.buttonMostrarPropiedades.setOnClickListener {
            val intent = Intent(this, MostrarPropiedadesActivity::class.java)
            startActivity(intent)
        }
    }
}
