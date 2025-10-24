package com.example.appmovilconalep

data class Asistencia(
    var id_asistencia: Int,
    var id_alumno: Int,
    var fecha: String,
    var estatus: String,
    var justificacion: String
)
