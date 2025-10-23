package com.example.appmovilconalep

data class Asistencia(
    var id: Int = 0,
    var idAlumno: Int,
    var fecha: String,
    var asistio: Boolean,
    var justificada: Boolean
)