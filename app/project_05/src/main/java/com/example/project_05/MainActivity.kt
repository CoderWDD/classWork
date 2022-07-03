package com.example.project_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var count: Int = 0
    private lateinit var txCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnShowToast = findViewById<Button>(R.id.btnShowToast)
        btnShowToast.setOnClickListener {
            Toast.makeText(this,"Hello world", Toast.LENGTH_SHORT).show()
        }


        var btnCount = findViewById<Button>(R.id.btnCount)

        txCount = findViewById<TextView>(R.id.tvCount)

        btnCount.setOnClickListener {
            count++
            txCount.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count_value",count)
        Log.i("myTag", "onSaveInstanceState: " + count.toString())

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        count = savedInstanceState.getInt("count_value")
        Log.i("myTag", "onRestoreInstanceState: " + count.toString())
        if (txCount != null)
            txCount.text = count.toString()
    }
}