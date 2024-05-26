package com.example.dailyfinity.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dailyfinity.R
import com.example.dailyfinity.adapters.NewsAdapter
import com.example.dailyfinity.databinding.FragmentSavedNewsBinding
import com.example.dailyfinity.databinding.FragmentSearchNewsBinding
import com.example.dailyfinity.viewModel.NewsViewModel


class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding: FragmentSearchNewsBinding

}