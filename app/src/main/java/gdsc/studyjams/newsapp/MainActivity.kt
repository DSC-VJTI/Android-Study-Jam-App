package gdsc.studyjams.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import gdsc.studyjams.newsapp.database.bookmark.BookmarkRoomDatabase
import gdsc.studyjams.newsapp.databinding.ActivityMainBinding
import gdsc.studyjams.newsapp.repository.NewsRepository
import gdsc.studyjams.newsapp.viewmodels.ListViewModel
import gdsc.studyjams.newsapp.viewmodels.ListViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = NewsRepository(BookmarkRoomDatabase.getDatabase(this))
        val viewModelProviderFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[ListViewModel::class.java]

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // adds actions in the ActionBar that get propagated to the NavController such as the back arrow
        setupActionBarWithNavController(navController)


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

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}