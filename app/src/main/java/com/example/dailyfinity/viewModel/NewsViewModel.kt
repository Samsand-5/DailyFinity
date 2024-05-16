package com.example.dailyfinity.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.dailyfinity.models.NewsResponse
import com.example.dailyfinity.util.Resource

class NewsViewModel {

    val headLines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var headLinesPage = 1
    var headLinesResponse: NewsResponse? = null
}