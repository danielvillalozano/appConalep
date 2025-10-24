package com.example.appmovilconalep

import android.content.Context
import android.database.Cursor
import com.example.appmovilconalep.modelos.Grupos

class GruposDB(private val context: Context) {

    private val dbHelper = DBHelper(context)

    fun obtenerTodos(): List<Grupos> {
        val listaGrupos = mutableListOf<Grupos>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM ${DefineTabla.Grupos.TABLA}", null)

        if (cursor.moveToFirst()) {
            do {
                val grupo = Grupos(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(DefineTabla.Grupos.ID)),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow(DefineTabla.Grupos.NOMBRE))
                )
                listaGrupos.add(grupo)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listaGrupos
    }
}
