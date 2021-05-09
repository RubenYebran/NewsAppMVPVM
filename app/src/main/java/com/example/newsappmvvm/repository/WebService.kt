package com.example.newsappmvvm.repository

import com.example.newsappmvvm.data.model.NewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("everything")

    suspend fun getNews(
            @Query("q") q: String,
            @Query("apiKey") apiKey: String
    ): NewsList
}

