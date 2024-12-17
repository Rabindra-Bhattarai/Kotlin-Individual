package com.example.kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Retrieve data from intent
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val confirmPassword = intent.getStringExtra("confirmPassword")
        val rememberMe = intent.getBooleanExtra("rememberMe", false)
        val city = intent.getStringExtra("city")

        // Display data
        findViewById<TextView>(R.id.displayUsername).text = "Name: $username"
        findViewById<TextView>(R.id.displayEmail).text = "Email: $email"
        findViewById<TextView>(R.id.displayPassword).text = "Password: $password"
        findViewById<TextView>(R.id.displayConfirmPassword).text = "Confirm Password: $confirmPassword"
        findViewById<TextView>(R.id.displayRememberMe).text = "Remember Me: ${if (rememberMe) "Yes" else "No"}"
        findViewById<TextView>(R.id.displayCity).text = "City: $city"
    }
}
