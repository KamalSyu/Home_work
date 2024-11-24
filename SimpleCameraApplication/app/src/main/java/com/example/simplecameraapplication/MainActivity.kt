package com.example.simplecameraapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecameraapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Set click listeners for the buttons
        binding.buttonCamera.setOnClickListener {
            // Navigate to CameraActivity
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        binding.buttonGallery.setOnClickListener {
            // Navigate to GalleryActivity
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }
    }
}