package gdsc.stydyjams.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // check if user is logged in
        val loggedIn = false
        if (!loggedIn) {
            // send to login page
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
            this.finish()
        }
        // else stay here

    }
}