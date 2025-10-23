package com.example.appmovilconalep

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class AsistenciaDB(context: Context) : SQLiteOpenHelper(context, "Asistencias.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE asistencia (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "alumno TEXT NOT NULL, " +
                    "grupo TEXT NOT NULL, " +
                    "fecha TEXT NOT NULL)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS asistencia")
        onCreate(db)
    }

    fun insertar(alumno: String, grupo: String, fecha: String, context: Context): Boolean {
        val db = writableDatabase
        val valores = ContentValues().apply {
            put("alumno", alumno)
            put("grupo", grupo)
            put("fecha", fecha)
        }

        val resultado = db.insert("asistencia", null, valores)
        db.close()

        return if (resultado != -1L) {
            Toast.makeText(context, "Asistencia registrada", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(context, "Error al registrar asistencia", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
