package com.example.appmovilconalep.basedatos

object DefineTabla {

    object Grupo {
        const val NOMBRE_TABLA = "grupo"
        const val COLUMNA_ID = "id"
        const val COLUMNA_NOMBRE = "nombre"
    }

    object Alumno {
        const val NOMBRE_TABLA = "alumno"
        const val COLUMNA_ID = "id"
        const val COLUMNA_NOMBRE = "nombre"
        const val COLUMNA_MATRICULA = "matricula"
        const val COLUMNA_ID_GRUPO = "idGrupo"
    }

    object Asistencia {
        const val NOMBRE_TABLA = "asistencia"
        const val COLUMNA_ID = "id"
        const val COLUMNA_ID_ALUMNO = "idAlumno"
        const val COLUMNA_FECHA = "fecha"
        const val COLUMNA_ASISTIO = "asistio"
        const val COLUMNA_JUSTIFICADA = "justificada"
    }
}