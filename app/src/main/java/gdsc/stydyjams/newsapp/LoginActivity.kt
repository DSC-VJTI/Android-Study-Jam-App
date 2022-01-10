package gdsc.stydyjams.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import gdsc.stydyjams.newsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            goToDashboard()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        auth = Firebase.auth
        setContentView(R.layout.activity_login)

        val button: Button = findViewById(R.id.activity_login_button)
        val emailField: EditText = findViewById(R.id.activity_login_email)
        val passwordField: EditText = findViewById(R.id.activity_login_password)
        val registerField: TextView = findViewById(R.id.activity_login_register)

        button.setOnClickListener {
            if (validateAndLogin(emailField, passwordField)) {
                auth.signInWithEmailAndPassword(emailField.text.toString(), passwordField.text.toString())
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful) {
                            goToDashboard()
                        }

                        else {
                            Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        registerField.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
            this.finish()
        }
    }

    private fun validateAndLogin(emailField: EditText, passwordField: EditText): Boolean {
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

        // validate from database here

        return check
    }

    private fun goToDashboard() {
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
        val dashboardIntent = Intent(this, MainActivity::class.java)
        startActivity(dashboardIntent)
        this.finish()
    }

}