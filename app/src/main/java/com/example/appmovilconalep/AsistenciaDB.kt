package com.example.appmovilconalep.basedatos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class AsistenciaDB(context: Context) {

    private val dbHelper = DBHelper(context)

    fun insertar(asistencia: com.example.appmovilconalep.Asistencia): Boolean {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val valores = ContentValues().apply {
            put(DefineTabla.COL_ID_ALUMNO_ASIS, asistencia.idAlumno)
            put(DefineTabla.COL_FECHA, asistencia.fecha)
            put(DefineTabla.COL_ASISTIO, if (asistencia.asistio) 1 else 0)
            put(DefineTabla.COL_JUSTIFICADA, if (asistencia.justificada) 1 else 0)
        }

        val resultado = db.insert(DefineTabla.TABLA_ASISTENCIA, null, valores)
        db.close()
        return resultado != -1L
    }

    fun obtenerPorAlumno(idAlumno: Int): List<com.example.appmovilconalep.Asistencia> {
        val db = dbHelper.readableDatabase
        val lista = mutableListOf<com.example.appmovilconalep.Asistencia>()

        val query = """
            SELECT ${DefineTabla.COL_FECHA}, ${DefineTabla.COL_ASISTIO}, ${DefineTabla.COL_JUSTIFICADA}
            FROM ${DefineTabla.TABLA_ASISTENCIA}
            WHERE ${DefineTabla.COL_ID_ALUMNO_ASIS} = ?
            ORDER BY ${DefineTabla.COL_FECHA} DESC
        """.trimIndent()

        val cursor: Cursor = db.rawQuery(query, arrayOf(idAlumno.toString()))
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    com.example.appmovilconalep.Asistencia(
                        id = 0,
                        idAlumno = idAlumno,
                        fecha = cursor.getString(0),
                        asistio = cursor.getInt(1) == 1,
                        justificada = cursor.getInt(2) == 1
                    )
                )
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return lista
    }
}
