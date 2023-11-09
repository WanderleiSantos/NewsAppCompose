package com.wanderlei.newsappcompose.domain.usecases.news

import com.wanderlei.newsappcompose.data.local.NewsDao
import com.wanderlei.newsappcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow


class SelectArticles(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}