package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    // Declare UI components
    private lateinit var spinner: Spinner
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var rememberMe: RadioButton
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize UI components
        username = findViewById(R.id.editUsernameRegister)
        email = findViewById(R.id.editEmailRegister)
        password = findViewById(R.id.editPasswordRegister)
        confirmPassword = findViewById(R.id.editConfirmPassword)
        rememberMe = findViewById(R.id.editRememberMe)
        submitButton = findViewById(R.id.EditRegisterBtn)
        spinner = findViewById(R.id.editSelectPlace)

        // Spinner setup
        val cities = listOf("Kathmandu", "Bhagalpur", "Lalita")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Handle Submit Button Click
        submitButton.setOnClickListener {
            val selectedCity = spinner.selectedItem.toString()
            val enteredUsername = username.text.toString()
            val enteredEmail = email.text.toString()
            val enteredPassword = password.text.toString()
            val enteredConfirmPassword = confirmPassword.text.toString()
            val isRememberMeChecked = rememberMe.isChecked

            // Input validation
            if (enteredUsername.isEmpty() || enteredEmail.isEmpty() || enteredPassword.isEmpty() || enteredConfirmPassword.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (enteredPassword != enteredConfirmPassword) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pass data to the next activity
            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra("username", enteredUsername)
                putExtra("email", enteredEmail)
                putExtra("password", enteredPassword)
                putExtra("confirmPassword", enteredConfirmPassword)
                putExtra("rememberMe", isRememberMeChecked)
                putExtra("city", selectedCity)
            }
            startActivity(intent)
        }

        // Handle window insets for proper padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
