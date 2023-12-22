package com.aquasense.ui.autentikasi.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.aquasense.R
import com.aquasense.ui.autentikasi.login.LoginActivity
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var namaInputLayout: TextInputLayout
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        namaInputLayout = findViewById(R.id.nama)
        emailInputLayout = findViewById(R.id.emailregis)
        passwordInputLayout = findViewById(R.id.passwordregis)

        val registerButton: AppCompatButton = findViewById(R.id.btn_register)
        val loginButton: AppCompatButton = findViewById(R.id.btn_login)

        registerButton.setOnClickListener {
            if (validateRegistration()) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        loginButton.setOnClickListener {
            if (validateRegistration()) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validateRegistration(): Boolean {
        val nama = namaInputLayout.editText?.text.toString()
        val email = emailInputLayout.editText?.text.toString()
        val password = passwordInputLayout.editText?.text.toString()

        if (nama.isEmpty()) {
            namaInputLayout.error = "Nama tidak boleh kosong"
            return false
        }

        if (email.isEmpty()) {
            emailInputLayout.error = "Email tidak boleh kosong"
            return false
        }

        if (password.isEmpty() || password.length < 6) {
            passwordInputLayout.error = "Password tidak boleh kosong dan harus lebih dari 6 karakter"
            return false
        }

        return true
    }
}