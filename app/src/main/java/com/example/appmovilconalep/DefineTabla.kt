package com.example.appmovilconalep.basedatos

object DefineTabla {
    const val NOMBRE_BD = "controlconalep.db"
    const val VERSION = 1

    const val TABLA_ALUMNOS = "Alumnos"
    const val TABLA_GRUPOS = "Grupos"
    const val TABLA_ASISTENCIA = "Asistencia"

    const val COL_ID_ALUMNO = "id"
    const val COL_NOMBRE = "nombre"
    const val COL_MATRICULA = "matricula"
    const val COL_ID_GRUPO = "idGrupo"

    const val COL_ID_GRUPO_PK = "id"
    const val COL_NOMBRE_GRUPO = "nombre"

    const val COL_ID_ASISTENCIA = "id"
    const val COL_ID_ALUMNO_ASIS = "idAlumno"
    const val COL_FECHA = "fecha"
    const val COL_ASISTIO = "asistio"
    const val COL_JUSTIFICADA = "justificada"
}
