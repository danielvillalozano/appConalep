package com.example.appmovilconalep

package com.example.controlconalep

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class GruposActivity : AppCompatActivity() {

    lateinit var listViewGrupos: ListView

    // Lista simulada de grupos por ahora
    val grupos = listOf(
        Grupo(1, "1°A"),
        Grupo(2, "2°B"),
        Grupo(3, "3°C")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grupos)

        listViewGrupos = findViewById(R.id.lvGrupos)

        val nombresGrupos = grupos.map { it.nombre }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nombresGrupos)
        listViewGrupos.adapter = adapter

        listViewGrupos.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val grupoSeleccionado = grupos[position]
            val intent = Intent(this, AlumnosActivity::class.java)
            intent.putExtra("idGrupo", grupoSeleccionado.id)
            startActivity(intent)
        }
    }
}
