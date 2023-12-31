package com.wanderlei.newsappcompose.domain.usecases.news

import com.wanderlei.newsappcompose.domain.model.Article
import com.wanderlei.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class SelectArticles(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.getArticles()
    }
}