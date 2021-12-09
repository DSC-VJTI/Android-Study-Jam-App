package gdsc.stydyjams.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import gdsc.stydyjams.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var news = mutableListOf(
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
            HeadlineItem("India wins a Gold Medal", R.drawable.img1),
        )

        val adapter = RecyclerViewAdapter(news)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

//        // check if user is logged in
//        val loggedIn = false
//        if (!loggedIn) {
//            // send to login page
//            val loginIntent = Intent(this, LoginActivity::class.java)
//            startActivity(loginIntent)
//            this.finish()
//        }
//        // else stay here

    }
}