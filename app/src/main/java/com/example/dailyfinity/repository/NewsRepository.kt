package com.example.dailyfinity.repository

import androidx.lifecycle.LiveData
import com.example.dailyfinity.api.RetrofitInstance
import com.example.dailyfinity.db.ArticleDao
import com.example.dailyfinity.db.ArticleDatabase
import com.example.dailyfinity.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadLines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadLines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavoriteNews() = db.getArticleDao().getAllArticles()

    fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}