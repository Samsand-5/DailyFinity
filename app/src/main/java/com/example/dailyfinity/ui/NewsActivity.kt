package com.example.dailyfinity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.dailyfinity.R
import com.example.dailyfinity.databinding.ActivityNewsBinding
import com.example.dailyfinity.db.ArticleDatabase
import com.example.dailyfinity.repository.NewsRepository
import com.example.dailyfinity.viewModel.NewsViewModel
import com.example.dailyfinity.viewModel.NewsViewModelProviderFactory

class NewsActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var binding: ActivityNewsBinding
    lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        newsViewModel = ViewModelProvider(this,viewModelProviderFactory).get(newsViewModel::class.java)

        navController = findNavController(R.id.newsNavHostFragment)
        setupActionBarWithNavController(navController)

    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}