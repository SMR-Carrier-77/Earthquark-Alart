package com.example.earthquarkalartapp.views.dashboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.earthquarkalartapp.R
import com.example.earthquarkalartapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bindng : ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindng.root)


        navController = findNavController(R.id.fragmentDashboard)

        bindng.sellerBottomNavigationView.setupWithNavController(navController)

        val appbarConfig = AppBarConfiguration(
            setOf(
                R.id.home_Dashboard,
                R.id.alart_Dashboard,
                R.id.setting_Dashboard
            )
        )

        setupActionBarWithNavController(navController , appbarConfig)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu , menu)
        return super.onCreateOptionsMenu(menu)
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_report->{
                Toast.makeText(this , "Report" , Toast.LENGTH_SHORT).show()
            }
            R.id.menu_setting->{
                Toast.makeText(this , "Setting" , Toast.LENGTH_SHORT).show()
            }
            R.id.menu_logout->{

                auth.signOut()
                startActivity(Intent(this , MainActivity::class.java))
                finish()

            }
        }

        return super.onOptionsItemSelected(item)
    }



}
     */
}