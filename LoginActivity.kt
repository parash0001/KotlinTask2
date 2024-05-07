package com.example.may7_task

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private val ActivityLoginBinding.buttonRegister: Any
    get() {
        TODO("Not yet implemented")
    }
private val Any.text: Any
    get() {
        TODO("Not yet implemented")
    }
private val ActivityLoginBinding.editTextPassword: Any
    get() {
        TODO("Not yet implemented")
    }
private var Any.isChecked: Boolean
    get() {
        TODO("Not yet implemented")
    }
    set(value) = Unit

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)

        // Check if Remember Me is selected and pre-fill the email and password fields
        if (sharedPreferences.getBoolean("rememberMe", false)) {
            binding.checkBoxRememberMe.isChecked = true
            binding.editTextEmail.setText(sharedPreferences.getString("email", ""))
            binding.editTextPassword.setText(sharedPreferences.getString("password", ""))
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Dummy validation, replace with your actual validation logic
            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (binding.checkBoxRememberMe.isChecked) {
                    with(sharedPreferences.edit()) {
                        putBoolean("rememberMe", true)
                        putString("email", email)
                        putString("password", password)
                        apply()
                    }
                } else {
                    with(sharedPreferences.edit()) {
                        remove("rememberMe")
                        remove("email")
                        remove("password")
                        apply()
                    }
                }

                // Successful login, navigate to dashboard
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonRegister.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Dummy validation, replace with your actual validation logic
            if (email.isNotEmpty() && password.isNotEmpty()) {
                with(sharedPreferences.edit()) {
                    putString("email", email)
                    putString("password", password)
                    apply()
                }
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setContentView(root: Any) {

    }
}

private fun Any.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}

private fun Any.setText(string: String?) {
    TODO("Not yet implemented")
}
