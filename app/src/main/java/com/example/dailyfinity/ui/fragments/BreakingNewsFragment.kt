package com.example.dailyfinity.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinity.R
import com.example.dailyfinity.adapters.NewsAdapter
import com.example.dailyfinity.databinding.FragmentArticleBinding
import com.example.dailyfinity.databinding.FragmentBreakingNewsBinding
import com.example.dailyfinity.ui.NewsActivity
import com.example.dailyfinity.viewModel.NewsViewModel


class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var retryButton: Button
    lateinit var errorText: TextView
    lateinit var itemHeadlinesError: CardView
    lateinit var binding: FragmentBreakingNewsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBreakingNewsBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
    }

    var isError = false
    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    private fun hideProgressBar(){
        binding.paginationProgressBar.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressBar(){
        binding.paginationProgressBar.visibility = View.INVISIBLE
        isLoading = true
    }

    private fun hideErrorMessage(){
        itemHeadlinesError.visibility = View.INVISIBLE
        isError = false
    }

    private fun showErrorMessage(message: String){
        itemHeadlinesError.visibility = View.VISIBLE
        errorText.text = message
        isError = true
    }

    val scrollListener = object: RecyclerView.OnScrollListener(){

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            val isNoError = !isError
            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }
    }
}