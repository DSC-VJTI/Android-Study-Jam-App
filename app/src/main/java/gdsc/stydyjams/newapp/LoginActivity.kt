package gdsc.stydyjams.newapp

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

        val button : Button = findViewById(R.id.activity_login_button)
        val emailField : EditText = findViewById(R.id.activity_login_email)
        val passwordField : EditText = findViewById(R.id.activity_login_password)
        val registerRedirect : TextView = findViewById(R.id.activity_login_register)

        button.setOnClickListener {

            if(validate(emailField, passwordField))
            {
                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
            }
        }



    }


    private fun validate( emailField : EditText, passwordField : EditText ) : Boolean
    {
        var check = true

        if(emailField.text.isBlank())
        {
            check=false
            emailField.error = "Please enter an email"
            emailField.requestFocus()
        }

        if(passwordField.text.isBlank())
        {
            check=false
            passwordField.error = "Please enter your password"
            passwordField.requestFocus()
        }

        //check from the server/database if the credentials are correct

        return check
    }
}