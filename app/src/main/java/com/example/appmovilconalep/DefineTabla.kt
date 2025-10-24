package com.example.appmovilconalep

class DefineTabla {
    companion object {
        const val DB_NAME = "app_movil_conalep.db"
        const val DB_VERSION = 1

        // Tabla GRUPOS
        const val TABLA_GRUPOS = "grupos"
        const val CAMPO_ID_GRUPO = "id_grupo"
        const val CAMPO_NOMBRE_GRUPO = "nombre_grupo"

        // Tabla ALUMNOS
        const val TABLA_ALUMNOS = "alumnos"
        const val CAMPO_ID_ALUMNO = "id_alumno"
        const val CAMPO_NOMBRE_ALUMNO = "nombre_alumno"
        const val CAMPO_ID_GRUPO_FK = "id_grupo"

        // Tabla HISTORIAL
        const val TABLA_HISTORIAL = "historial"
        const val CAMPO_ID_HISTORIAL = "id_historial"
        const val CAMPO_ID_ALUMNO_FK = "id_alumno"
        const val CAMPO_FECHA = "fecha"
        const val CAMPO_ASISTENCIA = "asistencia"
    }
}
