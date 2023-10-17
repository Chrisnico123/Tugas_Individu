package com.example.loginregisterapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val registerButton = findViewById<Button>(R.id.btn_register)
        val nameValue: EditText = findViewById(R.id.input_name)
        val emailValue: EditText = findViewById(R.id.input_email)
        val passwordValue: EditText = findViewById(R.id.input_password)

        val backButton = findViewById<ImageView>(R.id.button_back)

        backButton.setOnClickListener {
            val changePage = Intent(this, MainActivity::class.java)
            startActivity(changePage)
            finish()
        }

        registerButton.setOnClickListener {
            val name = nameValue.text.toString()
            val email = nameValue.text.toString()
            val password = passwordValue.text.toString()

            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()
            val intent = Intent(this , LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }




}