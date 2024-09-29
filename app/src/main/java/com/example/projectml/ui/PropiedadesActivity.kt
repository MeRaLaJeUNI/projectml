package com.example.projectml.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectml.databinding.ActivityPropiedadesBinding

class PropiedadesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropiedadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropiedadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Aquí puedes implementar la lógica para agregar propiedades
    }
}
