package com.example.dailyfinity.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfinity.R
import com.example.dailyfinity.adapters.NewsAdapter
import com.example.dailyfinity.databinding.FragmentBreakingNewsBinding
import com.example.dailyfinity.databinding.FragmentSavedNewsBinding
import com.example.dailyfinity.ui.NewsActivity
import com.example.dailyfinity.viewModel.NewsViewModel

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {

    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding: FragmentSavedNewsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSavedNewsBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        setUpRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_savedNewsFragment_to_articleFragment,bundle)
        }
    }

    val itemTouchHelperCallBack = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP,ItemTouchHelper.DOWN)
    private fun setUpRecyclerView(){
        newsAdapter = NewsAdapter()
        binding.recyclerFavourites.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}