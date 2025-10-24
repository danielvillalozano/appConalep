package com.example.appmovilconalep

import android.content.Context
import android.database.Cursor
import com.example.appmovilconalep.modelos.Alumnos

class AlumnosDB(private val context: Context) {

    private val dbHelper = DBHelper(context)

    fun obtenerTodos(): List<Alumnos> {
        val listaAlumnos = mutableListOf<Alumnos>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM ${DefineTabla.Alumnos.TABLA}", null)

        if (cursor.moveToFirst()) {
            do {
                val alumno = Alumnos(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(DefineTabla.Alumnos.ID)),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow(DefineTabla.Alumnos.NOMBRE)),
                    id_grupo = cursor.getInt(cursor.getColumnIndexOrThrow(DefineTabla.Alumnos.ID_GRUPO))
                )
                listaAlumnos.add(alumno)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listaAlumnos
    }
}
