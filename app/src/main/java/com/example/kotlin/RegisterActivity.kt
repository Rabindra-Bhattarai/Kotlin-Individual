
package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var username: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirmPassword: EditText
    lateinit var rememberMe: RadioButton
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        username = findViewById(R.id.editUsernameRegister)
        email = findViewById(R.id.editEmailRegister)
        password = findViewById(R.id.editPasswordRegister)
        confirmPassword = findViewById(R.id.editConfirmPassword)
        rememberMe = findViewById(R.id.editRememberMe)
        submitButton = findViewById(R.id.EditRegisterBtn)
        spinner = findViewById(R.id.editSelectPlace)

        val cities = listOf("Kathmandu", "Bhagalpur", "Lalita")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        submitButton.setOnClickListener {
            val selectedCity = spinner.selectedItem.toString()
            val enteredUsername = username.text.toString()
            val enteredEmail = email.text.toString()
            val enteredPassword = password.text.toString()
            val enteredConfirmPassword = confirmPassword.text.toString()
            val isRememberMeChecked = rememberMe.isChecked


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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
