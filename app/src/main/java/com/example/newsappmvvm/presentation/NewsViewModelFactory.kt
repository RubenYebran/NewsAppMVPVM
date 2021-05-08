package com.example.newsappmvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsappmvvm.repository.NewsRepository

class NewsViewModelFactory(private val repo: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(NewsRepository::class.java).newInstance(repo)
    }
}
