package com.example.appmovilconalep

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class GruposDB(context: Context) {
    private val dbHelper = DBHelper(context)
    private lateinit var db: SQLiteDatabase

    fun abrir() {
        db = dbHelper.readableDatabase
    }

    fun cerrar() {
        db.close()
    }

    fun obtenerNombrePorID(idGrupo: Int): String {
        var nombre = ""
        val cursor = db.rawQuery(
            "SELECT nombre FROM ${DefineTabla.TABLA_GRUPOS} WHERE ${DefineTabla.CAMPO_ID_GRUPO} = ?",
            arrayOf(idGrupo.toString())
        )
        if (cursor.moveToFirst()) {
            nombre = cursor.getString(0)
        }
        cursor.close()
        return nombre
    }
}
