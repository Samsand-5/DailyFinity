package com.example.dailyfinity.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dailyfinity.models.Article
import com.example.dailyfinity.models.NewsResponse
import com.example.dailyfinity.repository.NewsRepository
import com.example.dailyfinity.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(app: Application, val newsRepository: NewsRepository): AndroidViewModel(app) {

    val headLines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var headLinesPage = 1
    var headLinesResponse: NewsResponse? = null

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1
    var searchNewsResponse: NewsResponse? = null
    var newSearchQuery: String? = null
    var oldSearchQuery: String? = null

    private fun handleHeadLinesResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse->
                headLinesPage++;
                if(headLinesResponse == null){
                    headLinesResponse = resultResponse
                }
                else{
                    val oldArticles = headLinesResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(headLinesResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse->
                if(searchNewsResponse == null || newSearchQuery != null){
                    searchNewsPage = 1
                    oldSearchQuery = newSearchQuery
                    searchNewsResponse = resultResponse
                }
                else{
                    searchNewsPage++
                    val oldArticles = searchNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(searchNewsResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun addToFavorites(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }

    fun getFavoriteNews() = newsRepository.getFavoriteNews()

    fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }
}