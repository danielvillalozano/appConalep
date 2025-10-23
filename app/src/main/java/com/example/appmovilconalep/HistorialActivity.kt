package com.example.appmovilconalep

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.appmovilconalep.basedatos.AsistenciaDB

class HistorialActivity : AppCompatActivity() {

    lateinit var listaHistorial: ListView
    var idAlumno: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        listaHistorial = findViewById(R.id.lvHistorial)
        idAlumno = intent.getIntExtra("idAlumno", 0)

        val db = AsistenciaDB(this)
        val asistencias = db.obtenerPorAlumno(idAlumno)

        val datosMostrados = asistencias.map { asistencia ->
            val estado = when {
                asistencia.asistio -> "Asistió"
                asistencia.justificada -> "Falta Justificada"
                else -> "Falta Injustificada"
            }
            "${asistencia.fecha}: $estado"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datosMostrados)
        listaHistorial.adapter = adapter
    }
}
