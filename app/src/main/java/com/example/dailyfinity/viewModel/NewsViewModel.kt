package com.example.dailyfinity.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.dailyfinity.models.NewsResponse
import com.example.dailyfinity.repository.NewsRepository
import com.example.dailyfinity.util.Resource

class NewsViewModel(app: Application, val newsRepository: NewsRepository): AndroidViewModel(app) {

    val headLines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var headLinesPage = 1
    var headLinesResponse: NewsResponse? = null

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPAge = 1
    var searchNewsResponse: NewsResponse? = null
    var newSearchQuery: String? = null
    var oldSearchQuery: String? = null
}