package gdsc.stydyjams.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button:Button = findViewById(R.id.activity_login_button)
        val emailField : EditText= findViewById(R.id.activity_login_email)
        val passwordField : EditText = findViewById(R.id.activity_login_password)
        val registerField : TextView = findViewById(R.id.activity_login_register)

        button.setOnClickListener {
            if(validateAndLogin(emailField, passwordField))
            {
                println("MAKING TOAST")
                Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
            }
        }

        registerField.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
            this.finish()
        }

    }

    private fun validateAndLogin(emailField:EditText, passwordField:EditText) : Boolean
    {
        var check = true

        if(emailField.text.isBlank())
        {
            emailField.error = "Please enter a valid email"
            emailField.requestFocus()
            check=false
        }

        if(passwordField.text.isBlank())
        {
            passwordField.error = "Please enter a password"
            passwordField.requestFocus()
            check=false
        }

        //validate from database here

        return check
    }
}