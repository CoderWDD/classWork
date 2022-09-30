package com.example.project_06

import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var etPwd: EditText
    private var bPwdSwitch: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivPwdSwitch = findViewById<ImageView>(R.id.iv_pwd_switch)

        etPwd = findViewById(R.id.et_pwd)

        ivPwdSwitch.setOnClickListener {
            bPwdSwitch = !bPwdSwitch
            if (bPwdSwitch){
                ivPwdSwitch.setImageResource(R.drawable.ic_baseline_visibility_24)
                etPwd.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }else{
                ivPwdSwitch.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                etPwd.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
                etPwd.typeface = Typeface.DEFAULT
            }
        }
    }
}