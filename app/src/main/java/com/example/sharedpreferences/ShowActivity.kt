package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowActivity : AppCompatActivity() {
    private lateinit var showUsername: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        var pref: SharedPreferences? = this.getSharedPreferences("login", Context.MODE_PRIVATE)

        showUsername = findViewById(R.id.showUsername)

        val username = pref?.getString("username", "this is default value")
        showUsername.text = "Selamat Datang $username !"
    }
}