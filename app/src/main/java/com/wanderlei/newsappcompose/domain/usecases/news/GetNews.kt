package com.wanderlei.newsappcompose.domain.usecases.news

import androidx.paging.PagingData
import com.wanderlei.newsappcompose.domain.model.Article
import com.wanderlei.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(private val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}