package com.example.newsappmvvm.repository

import com.example.newsappmvvm.data.model.NewsList
import com.example.newsappmvvm.data.remote.NewsDataSource

class NewsRepositoryImpl(private val dataSource: NewsDataSource): NewsRepository{
    override suspend fun getNews(): NewsList = dataSource.getNews()
}