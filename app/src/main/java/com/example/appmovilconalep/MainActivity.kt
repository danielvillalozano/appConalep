package com.example.appmovilconalep

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar = findViewById(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            val intent = Intent(this, GruposActivity::class.java)
            startActivity(intent)
        }
    }
}
