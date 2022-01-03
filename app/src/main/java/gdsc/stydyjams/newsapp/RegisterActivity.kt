package gdsc.stydyjams.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_register)

        val button: Button = findViewById(R.id.activity_register_button)
        val emailField: EditText = findViewById(R.id.activity_register_email)
        val passwordField: EditText = findViewById(R.id.activity_register_password)
        val loginField: TextView = findViewById(R.id.activity_register_login)

        button.setOnClickListener {
            if (validateAndRegister(emailField, passwordField)) {
                Toast.makeText(this, "Successfully Registered!", Toast.LENGTH_SHORT).show()
            }
        }

        loginField.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
            this.finish()
        }
    }

    private fun validateAndRegister(emailField: EditText, passwordField: EditText): Boolean {
        var check = true
        if (emailField.text.isBlank()) {
            emailField.error = "Please enter a valid email"
            emailField.requestFocus()
            check = false
        }

        if (passwordField.text.isBlank()) {
            passwordField.error = "Please enter a password"
            passwordField.requestFocus()
            check = false
        }
        return check
    }

}