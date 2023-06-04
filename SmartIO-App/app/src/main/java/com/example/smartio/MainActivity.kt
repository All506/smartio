package com.example.smartio

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.smartio.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Will hide support bar
        supportActionBar?.hide()
        //No rotation
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        setupActionBarWithNavController(navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navigation)
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }
}