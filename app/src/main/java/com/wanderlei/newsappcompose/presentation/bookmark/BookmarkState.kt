package com.wanderlei.newsappcompose.presentation.bookmark

import com.wanderlei.newsappcompose.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)