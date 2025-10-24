package com.example.appmovilconalep

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.appmovilconalep.modelos.Alumnos
import java.text.SimpleDateFormat
import java.util.*

class RegistrarAsistenciaActivity : AppCompatActivity() {

    private lateinit var spinnerAlumnos: Spinner
    private lateinit var btnRegistrar: Button
    private lateinit var dbAlumnos: AlumnosDB
    private lateinit var dbAsistencia: AsistenciaDB
    private lateinit var alumnos: List<Alumnos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrar_asistencia)

        spinnerAlumnos = findViewById(R.id.spinnerAlumnos)
        btnRegistrar = findViewById(R.id.btnRegistrarAsistencia)

        dbAlumnos = AlumnosDB(this)
        dbAsistencia = AsistenciaDB(this)

        alumnos = dbAlumnos.obtenerTodos()
        val nombresAlumnos = alumnos.map { it.nombre }

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresAlumnos)
        spinnerAlumnos.adapter = adaptador

        btnRegistrar.setOnClickListener {
            val alumnoSeleccionado = alumnos[spinnerAlumnos.selectedItemPosition]

            val fechaActual = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val horaActual = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

            dbAsistencia.insertar(alumnoSeleccionado.id, fechaActual, horaActual)

            Toast.makeText(this, "Asistencia registrada", Toast.LENGTH_SHORT).show()
        }
    }
}
