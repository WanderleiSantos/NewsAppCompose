package com.wanderlei.newsappcompose.domain.usecases.news

import com.wanderlei.newsappcompose.domain.model.Article
import com.wanderlei.newsappcompose.domain.repository.NewsRepository

class SelectArticle (
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String): Article? {
        return newsRepository.getArticle(url)
    }
}