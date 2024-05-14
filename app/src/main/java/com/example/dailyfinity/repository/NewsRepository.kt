package com.example.dailyfinity.repository

import androidx.lifecycle.LiveData
import com.example.dailyfinity.api.RetrofitInstance
import com.example.dailyfinity.db.ArticleDao
import com.example.dailyfinity.db.ArticleDatabase
import com.example.dailyfinity.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadLines(countryCode: String, pageNumber: Int)=
        RetrofitInstance.api.getHeadLines(countryCode,pageNumber)


}