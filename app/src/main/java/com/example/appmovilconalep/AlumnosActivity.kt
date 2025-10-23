package com.example.appmovilconalep

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.appmovilconalep.basedatos.AsistenciaDB
import java.text.SimpleDateFormat
import java.util.*

class AlumnosActivity : AppCompatActivity() {

    lateinit var lista: ListView
    var alumnos = mutableListOf<Alumno>()
    var idGrupo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnos)

        lista = findViewById(R.id.lvAlumnos)
        idGrupo = intent.getIntExtra("idGrupo", 0)

        alumnos = mutableListOf(
            Alumno(1, "Ana Pérez", "A001", idGrupo),
            Alumno(2, "Luis Ramírez", "A002", idGrupo),
            Alumno(3, "Carmen Soto", "A003", idGrupo)
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, alumnos.map { it.nombre })
        lista.adapter = adapter

        lista.setOnItemClickListener { _, _, position, _ ->
            val alumno = alumnos[position]
            mostrarDialogoAsistencia(alumno)
        }

        // Clic largo para ver historial
        lista.setOnItemLongClickListener { _, _, position, _ ->
            val alumno = alumnos[position]
            val intent = android.content.Intent(this, HistorialActivity::class.java)
            intent.putExtra("idAlumno", alumno.id)
            startActivity(intent)
            true
        }
    }

    fun mostrarDialogoAsistencia(alumno: Alumno) {
        val opciones = arrayOf("Asistió", "Faltó", "Justificada")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Asistencia de ${alumno.nombre}")
        builder.setItems(opciones) { _, which ->
            val asistencia = Asistencia(
                id = 0,
                idAlumno = alumno.id,
                fecha = fechaActual(),
                asistio = (which == 0),
                justificada = (which == 2)
            )
            val db = AsistenciaDB(this)
            db.insertar(asistencia)
            Toast.makeText(this, "Asistencia guardada", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    fun fechaActual(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}
