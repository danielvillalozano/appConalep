package com.example.appmovilconalep

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class AlumnosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnos)

        val listaAlumnos = findViewById<ListView>(R.id.listaAlumnos)
        val alumnosDB = AlumnosDB(this)
        val lista = alumnosDB.obtenerTodos()

        val nombres = lista.map { it.nombre }

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, nombres)
        listaAlumnos.adapter = adaptador
    }
}
