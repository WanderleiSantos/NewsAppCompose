package com.wanderlei.newsappcompose.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wanderlei.newsappcompose.data.remote.NewsApi
import com.wanderlei.newsappcompose.data.remote.NewsPagingSource
import com.wanderlei.newsappcompose.domain.model.Article
import com.wanderlei.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi: NewsApi): NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}