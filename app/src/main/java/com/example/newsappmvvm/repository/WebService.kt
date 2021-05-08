package com.example.newsappmvvm.repository

import com.example.newsappmvvm.application.AppConstants
import com.example.newsappmvvm.data.model.NewsList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("everything")

    suspend fun getNews(
            @Query("q") q: String,
            @Query("apiKey") apiKey: String
    ): NewsList
}

