package com.example.appmovilconalep

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class GruposActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grupos)

        val listaGrupos = findViewById<ListView>(R.id.listaGrupos)
        val dbHelper = DBHelper(this)
        val gruposDB = GruposDB(dbHelper)
        val lista = gruposDB.obtenerGrupos()

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listaGrupos.adapter = adaptador
    }
}
