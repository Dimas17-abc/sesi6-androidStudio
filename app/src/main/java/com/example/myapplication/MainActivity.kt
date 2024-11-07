package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tuser : EditText = findViewById(R.id.username)
        val tpass : EditText = findViewById(R.id.password)
        val tombol : Button = findViewById(R.id.login)

        tombol.setOnClickListener {
            val username = tuser.text.toString()
            val password = tpass.text.toString()

            if (username == "admin" && password == "admin") {
                val intent = Intent(this, Home::class.java)
                intent.putExtra("usr", username)
                startActivity(intent)
            } else {
                Toast.makeText(this, "login salah", Toast.LENGTH_SHORT).show()
                tuser.text.clear()
                tpass.text.clear()
            }
        }
    }
}