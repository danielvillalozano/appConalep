package com.example.appmovilconalep

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.appmovilconalep.modelos.Asistencia
import com.example.appmovilconalep.modelos.Alumnos
import com.example.appmovilconalep.modelos.Grupos

class HistorialActivity : AppCompatActivity() {

    private lateinit var lista: ListView
    private lateinit var adaptador: ArrayAdapter<String>
    private val datos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historial)

        lista = findViewById(R.id.listaHistorial)

        val dbAsistencia = AsistenciaDB(this)
        val dbAlumnos = AlumnosDB(this)
        val dbGrupos = GruposDB(this)

        val asistencias: List<Asistencia> = dbAsistencia.obtenerTodos()
        val alumnos: List<Alumnos> = dbAlumnos.obtenerTodos()
        val grupos: List<Grupos> = dbGrupos.obtenerTodos()

        for (asistencia in asistencias) {
            val alumno = alumnos.find { it.id == asistencia.id_alumno }
            val grupo = grupos.find { it.id == alumno?.id_grupo }

            val registro = "Alumno: ${alumno?.nombre} | Grupo: ${grupo?.nombre} | Fecha: ${asistencia.fecha} | Hora: ${asistencia.hora}"
            datos.add(registro)
        }

        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)
        lista.adapter = adaptador
    }
}
