package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var inputUsername: EditText
    private lateinit var inputPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ShowActivity::class.java)
        var pref: SharedPreferences? = this.getSharedPreferences("login", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor? = pref?.edit()

        inputUsername = findViewById(R.id.username)
        inputPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = inputUsername.text.toString().trim()
            val password = inputPassword.text.toString().trim()

            // check if password is 12345678
            if (password != "12345678") {
                inputPassword.error = "Password is incorrect"
                return@setOnClickListener
            }

            editor?.putString("username", username)
            editor?.commit()
            startActivity(intent)
        }
    }
}