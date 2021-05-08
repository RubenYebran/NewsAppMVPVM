package com.example.newsappmvvm.repository

import com.example.newsappmvvm.data.model.NewsList

interface NewsRepository {
    suspend fun getNews(): NewsList
}