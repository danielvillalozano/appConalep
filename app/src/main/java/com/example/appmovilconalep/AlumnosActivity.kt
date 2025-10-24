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
        val dbHelper = DBHelper(this)
        val alumnosDB = AlumnosDB(dbHelper)
        val lista = alumnosDB.obtenerAlumnos()

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listaAlumnos.adapter = adaptador
    }
}
