package com.example.newsappmvvm.presentation

import androidx.lifecycle.*
import com.example.newsappmvvm.contract.NewsContract
import com.example.newsappmvvm.core.Result
import com.example.newsappmvvm.data.model.Article
import com.example.newsappmvvm.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class NewsPresenter(private val repo: NewsRepository): ViewModel(), NewsContract.NewsPresenter{

    private val newsArticle = MutableLiveData<Article>()

    override fun fetchNews() = liveData(Dispatchers.IO){
        emit(Result.Loading())
        try{
            emit(Result.Success(repo.getNews()))
        }catch (e: Exception){
            emit(Result.Failure(e))
        }
    }

    override fun setArticle(article: Article){
        newsArticle.value = article
    }

    override fun getArticle(): LiveData<Article>{
        return newsArticle
    }
}
