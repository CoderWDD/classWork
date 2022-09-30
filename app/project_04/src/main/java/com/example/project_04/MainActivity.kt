package com.example.project_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMessage = findViewById<EditText>(R.id.message)
        val btnSendMessage = findViewById<Button>(R.id.send_message)
        btnSendMessage.setOnClickListener {
            val message = etMessage.text
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MessageActivity::class.java)
            intent.putExtra("MESSAGE", message.toString())
            startActivity(intent)
        }
    }
}