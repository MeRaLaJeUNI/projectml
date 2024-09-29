package com.example.projectml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectml.R

class PropiedadesAdapter(private val propiedades: List<String>) : RecyclerView.Adapter<PropiedadesAdapter.PropiedadesViewHolder>() {

    class PropiedadesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val propiedadTextView: TextView = view.findViewById(R.id.textViewPropiedad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropiedadesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_propiedad, parent, false)
        return PropiedadesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PropiedadesViewHolder, position: Int) {
        holder.propiedadTextView.text = propiedades[position]
    }

    override fun getItemCount() = propiedades.size
}

