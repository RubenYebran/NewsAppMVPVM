package com.example.newsappmvvm.data.remote

import com.example.newsappmvvm.application.AppConstants
import com.example.newsappmvvm.data.model.NewsList
import com.example.newsappmvvm.repository.WebService

class NewsDataSource(private val webService: WebService) {
    suspend fun getNews(): NewsList = webService.getNews(AppConstants.QUERY, AppConstants.API_KEY)
}
