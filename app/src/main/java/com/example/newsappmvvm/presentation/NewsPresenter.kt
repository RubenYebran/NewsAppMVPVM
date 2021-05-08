package com.example.newsappmvvm.presentation

import androidx.lifecycle.*
import com.example.newsappmvvm.contract.NewsContract
import com.example.newsappmvvm.core.Resource
import com.example.newsappmvvm.data.model.Article
import com.example.newsappmvvm.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class NewsPresenter(private val repo: NewsRepository): ViewModel(), NewsContract.NewsPresenter{

    private val newsArticle = MutableLiveData<Article>()

    override fun fetchNews() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repo.getNews()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    override fun setArticle(article: Article){
        newsArticle.value = article
    }

    override fun getArticle(): LiveData<Article>{
        return newsArticle
    }
}
