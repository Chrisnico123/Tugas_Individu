package com.example.loginregisterapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val backButton = findViewById<ImageView>(R.id.btn_back)
        val logButton = findViewById<Button>(R.id.btn_login)

        backButton.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        logButton.setOnClickListener {
            val emailValue = findViewById<EditText>(R.id.input_email)
            val passwordValue = findViewById<EditText>(R.id.input_password)
            val email = emailValue.text.toString()
            val password = passwordValue.text.toString()
            val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val savedEmail = sharedPreferences.getString("email", "")
            val savedPassword = sharedPreferences.getString("password", "")
            if (email == savedEmail && password == savedPassword) {
                val loginSuccessIntent = Intent(this, Beranda::class.java)
                startActivity(loginSuccessIntent)
                finish()
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}