package com.example.newsappmvvm.ui.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.newsappmvvm.R
import com.example.newsappmvvm.contract.NewsContract
import com.example.newsappmvvm.core.Resource
import com.example.newsappmvvm.data.model.Article
import com.example.newsappmvvm.data.remote.NewsDataSource
import com.example.newsappmvvm.databinding.FragmentNewsBinding
import com.example.newsappmvvm.presentation.NewsPresenter
import com.example.newsappmvvm.presentation.NewsViewModelFactory
import com.example.newsappmvvm.repository.NewsAPI
import com.example.newsappmvvm.repository.NewsRepositoryImpl
import com.example.newsappmvvm.ui.news.adapter.NewsAdapter

class NewsFragment : Fragment(R.layout.fragment_news), NewsAdapter.OnArticleClickListener, NewsContract.NewsView {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter

    private val viewModel by activityViewModels<NewsPresenter>{
        NewsViewModelFactory(
            NewsRepositoryImpl(
                NewsDataSource(
                    NewsAPI.RetrofitNewsList.webservice
                )
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        initViewModel()
    }

    override fun initViewModel(){
        viewModel.fetchNews().observe(viewLifecycleOwner, {
            when (it){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter = NewsAdapter(it.data.articles,this@NewsFragment)
                    binding.rvNews.adapter = adapter
                }

                is Resource.Failure ->{
                    Log.d("Error","${it.exception}")
                }
            }
        })
    }

    override fun onArticleClick(article: Article){
        val action = R.id.action_newsFragment_to_newsDetailFragment
        viewModel.setArticle(article)
        findNavController().navigate(action)
    }
}