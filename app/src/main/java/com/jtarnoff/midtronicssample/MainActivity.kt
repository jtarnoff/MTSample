package com.jtarnoff.midtronicssample

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jtarnoff.midtronicssample.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Hide bottom nav on Country Fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_countries -> showBottomNav(navView)
                R.id.navigation_profile -> showBottomNav(navView)
                R.id.navigation_country -> {
                    hideBottomNav(navView)
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    supportActionBar?.setHomeButtonEnabled(false)
                }
            }
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_profile, R.id.navigation_countries, R.id.navigation_country
            )
        )
        appBarConfiguration
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun showBottomNav(navView: BottomNavigationView) {
        navView.visibility = View.VISIBLE
    }

    private fun hideBottomNav(navView: BottomNavigationView) {
        navView.visibility = View.GONE
    }
}