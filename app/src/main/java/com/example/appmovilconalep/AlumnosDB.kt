package com.example.appmovilconalep

import android.content.Context
import android.database.Cursor
import com.example.appmovilconalep.modelos.Alumnos

class AlumnosDB(private val context: Context) {

    private val dbHelper = DBHelper(context)

    fun obtenerTodos(): List<Alumnos> {
        val listaAlumnos = mutableListOf<Alumnos>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM ${DefineTabla.TABLA_ALUMNOS}", null)

        if (cursor.moveToFirst()) {
            do {
                val alumno = Alumnos(
                    id_alumno = cursor.getInt(cursor.getColumnIndexOrThrow(DefineTabla.CAMPO_ID_ALUMNO)),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow(DefineTabla.CAMPO_NOMBRE_ALUMNO)),
                    id_grupo = cursor.getInt(cursor.getColumnIndexOrThrow(DefineTabla.CAMPO_ID_GRUPO_FK))
                )
                listaAlumnos.add(alumno)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listaAlumnos
    }
}
