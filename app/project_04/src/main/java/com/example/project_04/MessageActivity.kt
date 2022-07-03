package com.example.project_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        val txMessage = findViewById<TextView>(R.id.message)
        txMessage.text = intent.getStringExtra("MESSAGE")
    }
}