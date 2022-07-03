package com.example.project_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnShowToast = findViewById<Button>(R.id.btnShowToast)
        btnShowToast.setOnClickListener {
            Toast.makeText(this,"Hello world",Toast.LENGTH_SHORT).show()
        }

        var txCount = findViewById<TextView>(R.id.tvCount)

        var btnCount = findViewById<Button>(R.id.btnCount)

        btnCount.setOnClickListener {
            txCount.text = (txCount.text.toString().toInt() + 1).toString()
        }
    }
}