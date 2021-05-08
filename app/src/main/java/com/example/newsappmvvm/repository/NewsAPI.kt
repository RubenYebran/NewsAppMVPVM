package com.example.newsappmvvm.repository

import com.example.newsappmvvm.application.AppConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPI {
    object RetrofitNewsList {
        val webservice: WebService by lazy {
            Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build().create(WebService::class.java)
        }
    }
}