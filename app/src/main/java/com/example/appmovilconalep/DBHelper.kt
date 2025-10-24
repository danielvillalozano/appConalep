package com.example.appmovilconalep

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(
    context,
    DefineTabla.DB_NAME,
    null,
    DefineTabla.DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        val createGrupos = """
            CREATE TABLE ${DefineTabla.TABLA_GRUPOS} (
                ${DefineTabla.CAMPO_ID_GRUPO} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DefineTabla.CAMPO_NOMBRE_GRUPO} TEXT
            )
        """.trimIndent()

        val createAlumnos = """
            CREATE TABLE ${DefineTabla.TABLA_ALUMNOS} (
                ${DefineTabla.CAMPO_ID_ALUMNO} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DefineTabla.CAMPO_NOMBRE_ALUMNO} TEXT,
                ${DefineTabla.CAMPO_ID_GRUPO_FK} INTEGER
            )
        """.trimIndent()

        val createHistorial = """
            CREATE TABLE ${DefineTabla.TABLA_HISTORIAL} (
                ${DefineTabla.CAMPO_ID_HISTORIAL} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DefineTabla.CAMPO_ID_ALUMNO_FK} INTEGER,
                ${DefineTabla.CAMPO_FECHA} TEXT,
                ${DefineTabla.CAMPO_ASISTENCIA} TEXT
            )
        """.trimIndent()

        db.execSQL(createGrupos)
        db.execSQL(createAlumnos)
        db.execSQL(createHistorial)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.TABLA_GRUPOS}")
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.TABLA_ALUMNOS}")
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.TABLA_HISTORIAL}")
        onCreate(db)
    }
}
