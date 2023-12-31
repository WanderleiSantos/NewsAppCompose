package com.wanderlei.newsappcompose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.wanderlei.newsappcompose.presentation.bookmark.BookmarkScreen
import com.wanderlei.newsappcompose.presentation.bookmark.BookmarkViewModel
import com.wanderlei.newsappcompose.presentation.home.HomeScreen
import com.wanderlei.newsappcompose.presentation.home.HomeViewModel
import com.wanderlei.newsappcompose.presentation.news_navigator.NewsNavigator
import com.wanderlei.newsappcompose.presentation.onboarding.OnBoardingScreen
import com.wanderlei.newsappcompose.presentation.onboarding.OnBoardingViewModel
import com.wanderlei.newsappcompose.presentation.search.SearchScreen
import com.wanderlei.newsappcompose.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                 NewsNavigator()
            }
        }
    }
}