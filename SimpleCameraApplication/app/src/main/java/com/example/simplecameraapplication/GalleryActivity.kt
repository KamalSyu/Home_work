package com.example.simplecameraapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplecameraapplication.databinding.ActivityGalleryBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = binding.photoRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val files = getFilesInDirectory()
        val adapter = FileAdapter(files)
        recyclerView.adapter = adapter

    }

    private fun getFilesInDirectory(): List<FileItem> {
        val directory = getOutputDirectory()
        val fileItems = mutableListOf<FileItem>()

        if (directory.exists() && directory.isDirectory) {
            val files = directory.listFiles()

            files?.forEach { file ->
                fileItems.add(FileItem(file.name, file.absolutePath, file.length()))
            }
        }

        return fileItems
    }

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }
}
