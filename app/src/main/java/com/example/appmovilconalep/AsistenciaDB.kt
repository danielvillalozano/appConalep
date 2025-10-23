package com.example.appmovilconalep.basedatos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.appmovilconalep.Asistencia

class AsistenciaDB(context: Context) {

    private val dbHelper = DBHelper(context)
    private lateinit var db: SQLiteDatabase

    fun insertar(asistencia: Asistencia): Long {
        db = dbHelper.writableDatabase
        val valores = ContentValues().apply {
            put("idAlumno", asistencia.idAlumno)
            put("fecha", asistencia.fecha)
            put("asistio", if (asistencia.asistio) 1 else 0)
            put("justificada", if (asistencia.justificada) 1 else 0)
        }
        return db.insert("asistencia", null, valores)
    }

    fun obtenerPorAlumno(idAlumno: Int): List<Asistencia> {
        db = dbHelper.readableDatabase
        val lista = mutableListOf<Asistencia>()
        val cursor = db.rawQuery("SELECT * FROM asistencia WHERE idAlumno = ?", arrayOf(idAlumno.toString()))
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val fecha = cursor.getString(2)
                val asistio = cursor.getInt(3) == 1
                val justificada = cursor.getInt(4) == 1
                lista.add(Asistencia(id, idAlumno, fecha, asistio, justificada))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }
}