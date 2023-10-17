package com.example.loginregisterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val regButton = findViewById<Button>(R.id.btn_1)
        val logButton = findViewById<Button>(R.id.btn_2)

        logButton.setOnClickListener {
            val changePage = Intent(this, RegisterActivity::class.java)
            startActivity(changePage)
            finish()
        }

        regButton.setOnClickListener {
            val changePage = Intent(this, LoginActivity::class.java)
            startActivity(changePage)
            finish()
        }
    }
}