package com.wanderlei.newsappcompose.domain.usecases.news

import com.wanderlei.newsappcompose.domain.model.Article
import com.wanderlei.newsappcompose.domain.repository.NewsRepository

class DeleteArticle (
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}