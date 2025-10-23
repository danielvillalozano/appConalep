package com.example.appmovilconalep.basedatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(
    context,
    DefineTabla.NOMBRE_BD,
    null,
    DefineTabla.VERSION
) {

    override fun onCreate(db: SQLiteDatabase) {
        val crearAlumnos = """
            CREATE TABLE ${DefineTabla.TABLA_ALUMNOS} (
                ${DefineTabla.COL_ID_ALUMNO} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DefineTabla.COL_NOMBRE} TEXT,
                ${DefineTabla.COL_MATRICULA} TEXT,
                ${DefineTabla.COL_ID_GRUPO} INTEGER
            )
        """.trimIndent()

        val crearGrupos = """
            CREATE TABLE ${DefineTabla.TABLA_GRUPOS} (
                ${DefineTabla.COL_ID_GRUPO_PK} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DefineTabla.COL_NOMBRE_GRUPO} TEXT
            )
        """.trimIndent()

        val crearAsistencia = """
            CREATE TABLE ${DefineTabla.TABLA_ASISTENCIA} (
                ${DefineTabla.COL_ID_ASISTENCIA} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DefineTabla.COL_ID_ALUMNO_ASIS} INTEGER,
                ${DefineTabla.COL_FECHA} TEXT,
                ${DefineTabla.COL_ASISTIO} INTEGER,
                ${DefineTabla.COL_JUSTIFICADA} INTEGER
            )
        """.trimIndent()

        db.execSQL(crearAlumnos)
        db.execSQL(crearGrupos)
        db.execSQL(crearAsistencia)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.TABLA_ALUMNOS}")
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.TABLA_GRUPOS}")
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.TABLA_ASISTENCIA}")
        onCreate(db)
    }
}
