package com.example.appmovilconalep.basedatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "control.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE ${DefineTabla.Grupo.NOMBRE_TABLA} (" +
                    "${DefineTabla.Grupo.COLUMNA_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "${DefineTabla.Grupo.COLUMNA_NOMBRE} TEXT)"
        )

        db.execSQL(
            "CREATE TABLE ${DefineTabla.Alumno.NOMBRE_TABLA} (" +
                    "${DefineTabla.Alumno.COLUMNA_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "${DefineTabla.Alumno.COLUMNA_NOMBRE} TEXT, " +
                    "${DefineTabla.Alumno.COLUMNA_MATRICULA} TEXT, " +
                    "${DefineTabla.Alumno.COLUMNA_ID_GRUPO} INTEGER)"
        )

        db.execSQL(
            "CREATE TABLE ${DefineTabla.Asistencia.NOMBRE_TABLA} (" +
                    "${DefineTabla.Asistencia.COLUMNA_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "${DefineTabla.Asistencia.COLUMNA_ID_ALUMNO} INTEGER, " +
                    "${DefineTabla.Asistencia.COLUMNA_FECHA} TEXT, " +
                    "${DefineTabla.Asistencia.COLUMNA_ASISTIO} INTEGER, " +
                    "${DefineTabla.Asistencia.COLUMNA_JUSTIFICADA} INTEGER)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.Grupo.NOMBRE_TABLA}")
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.Alumno.NOMBRE_TABLA}")
        db.execSQL("DROP TABLE IF EXISTS ${DefineTabla.Asistencia.NOMBRE_TABLA}")
        onCreate(db)
    }
}

class DBHelper {
}