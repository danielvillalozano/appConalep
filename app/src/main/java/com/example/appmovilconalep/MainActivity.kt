package com.example.appmovilconalep

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnGrupos: Button
    private lateinit var btnAlumnos: Button
    private lateinit var btnAsistencia: Button
    private lateinit var btnHistorial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGrupos = findViewById(R.id.btnGrupos)
        btnAlumnos = findViewById(R.id.btnAlumnos)
        btnAsistencia = findViewById(R.id.btnAsistencia)
        btnHistorial = findViewById(R.id.btnHistorial)

        btnGrupos.setOnClickListener {
            startActivity(Intent(this, GruposActivity::class.java))
        }

        btnAlumnos.setOnClickListener {
            startActivity(Intent(this, AlumnosActivity::class.java))
        }

        btnAsistencia.setOnClickListener {
            startActivity(Intent(this, RegistrarAsistenciaActivity::class.java))
        }

        btnHistorial.setOnClickListener {
            startActivity(Intent(this, HistorialActivity::class.java))
        }
    }
}
