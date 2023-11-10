package com.wanderlei.newsappcompose.presentation.details

import com.wanderlei.newsappcompose.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()
    object RemoveSideEffect: DetailsEvent()
}