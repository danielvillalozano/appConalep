package com.example.appmovilconalep.basedatos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class AsistenciaDB(context: Context) {

    private val dbHelper = DBHelper(context)

    // Insertar nueva asistencia
    fun insertarAsistencia(idAlumno: Int, fecha: String, asistio: Boolean, justificada: Boolean): Boolean {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val valores = ContentValues().apply {
            put(DefineTabla.COL_ID_ALUMNO_ASIS, idAlumno)
            put(DefineTabla.COL_FECHA, fecha)
            put(DefineTabla.COL_ASISTIO, if (asistio) 1 else 0)
            put(DefineTabla.COL_JUSTIFICADA, if (justificada) 1 else 0)
        }

        val resultado = db.insert(DefineTabla.TABLA_ASISTENCIA, null, valores)
        db.close()
        return resultado != -1L
    }

    // Obtener todas las asistencias por alumno
    fun obtenerAsistenciasPorAlumno(idAlumno: Int): List<Map<String, Any>> {
        val db = dbHelper.readableDatabase
        val lista = mutableListOf<Map<String, Any>>()

        val query = """
            SELECT ${DefineTabla.COL_FECHA}, ${DefineTabla.COL_ASISTIO}, ${DefineTabla.COL_JUSTIFICADA}
            FROM ${DefineTabla.TABLA_ASISTENCIA}
            WHERE ${DefineTabla.COL_ID_ALUMNO_ASIS} = ?
            ORDER BY ${DefineTabla.COL_FECHA} DESC
        """.trimIndent()

        val cursor: Cursor = db.rawQuery(query, arrayOf(idAlumno.toString()))

        if (cursor.moveToFirst()) {
            do {
                val asistencia = mapOf(
                    "fecha" to cursor.getString(0),
                    "asistio" to (cursor.getInt(1) == 1),
                    "justificada" to (cursor.getInt(2) == 1)
                )
                lista.add(asistencia)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return lista
    }

    // Obtener total de asistencias por alumno
    fun contarAsistencias(idAlumno: Int): Int {
        val db = dbHelper.readableDatabase
        val query = """
            SELECT COUNT(*)
            FROM ${DefineTabla.TABLA_ASISTENCIA}
            WHERE ${DefineTabla.COL_ID_ALUMNO_ASIS} = ? AND ${DefineTabla.COL_ASISTIO} = 1
        """.trimIndent()

        val cursor = db.rawQuery(query, arrayOf(idAlumno.toString()))
        val total = if (cursor.moveToFirst()) cursor.getInt(0) else 0

        cursor.close()
        db.close()
        return total
    }
}
