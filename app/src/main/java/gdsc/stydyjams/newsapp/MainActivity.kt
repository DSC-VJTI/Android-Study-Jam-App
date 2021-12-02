package gdsc.stydyjams.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //check if user is logged in
        var loggedIn:Boolean = false
        if(!loggedIn)
        {
            //send to login page
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
            this.finish()
        }
        //else stay here

    }
}