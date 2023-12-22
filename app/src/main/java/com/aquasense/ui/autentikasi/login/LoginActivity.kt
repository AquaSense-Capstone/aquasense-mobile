package com.aquasense.ui.autentikasi.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.aquasense.MainActivity
import com.aquasense.R
import com.aquasense.ui.autentikasi.register.RegisterActivity
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi TextInputLayout
        emailInputLayout = findViewById(R.id.email)
        passwordInputLayout = findViewById(R.id.password)

        val loginButton: AppCompatButton = findViewById(R.id.btn_login)
        val registerButton: AppCompatButton = findViewById(R.id.btn_register)

        loginButton.setOnClickListener {
            if (validateCredentials()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateCredentials(): Boolean {
        val email = emailInputLayout.editText?.text.toString()
        val password = passwordInputLayout.editText?.text.toString()

        if (email.isEmpty()) {
            emailInputLayout.error = "Email tidak boleh kosong"
            return false
        }

        if (password.isEmpty()) {
            passwordInputLayout.error = "Password tidak boleh kosong"
            return false
        }
        return true
    }
}