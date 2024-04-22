package com.rgbstudios.cxrslides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgbstudios.cxrslides.adapter.StudySlideAdapter
import com.rgbstudios.cxrslides.data.Datasource
import com.rgbstudios.cxrslides.databinding.ActivityStudyBinding

class StudyActivity : AppCompatActivity() {

    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?tbm=isch&q="
        const val SUFFIX = " radiological slides"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve a binding object that allows you to refer to views by id name
        // Names are converted from snake case to camel case.
        // For example, a View with the id word_one is referenced as binding.wordOne
        val binding = ActivityStudyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize data and pass into the adapter
        val myDataset = Datasource.slides

        // recyclerView
        val recyclerView = binding.studyRecyclerView
        recyclerView.adapter = StudySlideAdapter(this, myDataset)

        // Specify fixed size to improve performance
        binding.studyRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}