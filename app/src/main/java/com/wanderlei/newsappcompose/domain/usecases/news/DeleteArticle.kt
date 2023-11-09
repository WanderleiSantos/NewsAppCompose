package com.wanderlei.newsappcompose.domain.usecases.news

import com.wanderlei.newsappcompose.data.local.NewsDao
import com.wanderlei.newsappcompose.domain.model.Article

class DeleteArticle (
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article) {
        newsDao.delete(article)
    }
}