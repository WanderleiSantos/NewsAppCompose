package com.wanderlei.newsappcompose.presentation.details

sealed class DetailsEvent {
    object SaveArticle: DetailsEvent()
}