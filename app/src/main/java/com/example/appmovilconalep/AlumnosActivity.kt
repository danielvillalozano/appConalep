package com.example.appmovilconalep

package com.example.controlconalep

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.controlconalep.basedatos.AsistenciaDB
import java.text.SimpleDateFormat
import java.util.*

class AlumnosActivity : AppCompatActivity() {

    lateinit var lista: ListView
    var alumnos = mutableListOf<Alumno>()
    lateinit var idGrupo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnos)

        lista = findViewById(R.id.lvAlumnos)
        idGrupo = intent.getIntExtra("idGrupo", 0).toString()

        // Simulamos alumnos (más adelante vendrán de la BD)
        alumnos = mutableListOf(
            Alumno(1, "Ana Pérez", "A001", idGrupo.toInt()),
            Alumno(2, "Luis Ramírez", "A002", idGrupo.toInt()),
            Alumno(3, "Carmen Soto", "A003", idGrupo.toInt())
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, alumnos.map { it.nombre })
        lista.adapter = adapter

        lista.setOnItemClickListener { _, _, position, _ ->
            val alumno = alumnos[position]
            mostrarDialogoAsistencia(alumno)
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
