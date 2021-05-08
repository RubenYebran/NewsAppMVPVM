package com.example.newsappmvvm.contract

import androidx.lifecycle.LiveData
import com.example.newsappmvvm.core.Resource
import com.example.newsappmvvm.data.model.Article
import com.example.newsappmvvm.data.model.NewsList

interface NewsContract {

    interface NewsPresenter {
        fun fetchNews(): LiveData<Resource<NewsList>>
        fun setArticle(article: Article)
        fun getArticle(): LiveData<Article>
    }

    interface NewsView {
        fun initViewModel()
        fun onArticleClick(article: Article)
    }

    interface NewsDetail {
        fun showData()
    }
}