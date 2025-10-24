package com.example.appmovilconalep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGrupos = findViewById<Button>(R.id.btnGrupos)
        val btnAlumnos = findViewById<Button>(R.id.btnAlumnos)
        val btnHistorial = findViewById<Button>(R.id.btnHistorial)

        btnGrupos.setOnClickListener {
            val intent = Intent(this, GruposActivity::class.java)
            startActivity(intent)
        }

        btnAlumnos.setOnClickListener {
            val intent = Intent(this, AlumnosActivity::class.java)
            startActivity(intent)
        }

        btnHistorial.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)
        }
    }
}
