package com.example.appmovilconalep

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class AlumnosDB(context: Context) {
    private val dbHelper = DBHelper(context)
    private lateinit var db: SQLiteDatabase

    fun abrir() {
        db = dbHelper.readableDatabase
    }

    fun cerrar() {
        db.close()
    }

    fun obtenerNombrePorID(idAlumno: Int): String {
        var nombre = ""
        val cursor = db.rawQuery(
            "SELECT nombre FROM ${DefineTabla.TABLA_ALUMNOS} WHERE ${DefineTabla.CAMPO_ID_ALUMNO} = ?",
            arrayOf(idAlumno.toString())
        )
        if (cursor.moveToFirst()) {
            nombre = cursor.getString(0)
        }
        cursor.close()
        return nombre
    }
}
