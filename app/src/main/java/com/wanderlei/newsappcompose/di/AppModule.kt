package com.wanderlei.newsappcompose.di

import android.app.Application
import androidx.room.Room
import com.wanderlei.newsappcompose.data.local.NewsDao
import com.wanderlei.newsappcompose.data.local.NewsDatabase
import com.wanderlei.newsappcompose.data.local.NewsTypeConverter
import com.wanderlei.newsappcompose.data.manager.LocalUserManagerImpl
import com.wanderlei.newsappcompose.data.remote.NewsApi
import com.wanderlei.newsappcompose.data.remote.repository.NewsRepositoryImpl
import com.wanderlei.newsappcompose.domain.manager.LocalUserManager
import com.wanderlei.newsappcompose.domain.repository.NewsRepository
import com.wanderlei.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.wanderlei.newsappcompose.domain.usecases.app_entry.ReadAppEntry
import com.wanderlei.newsappcompose.domain.usecases.app_entry.SaveAppEntry
import com.wanderlei.newsappcompose.domain.usecases.news.GetNews
import com.wanderlei.newsappcompose.domain.usecases.news.NewsUseCases
import com.wanderlei.newsappcompose.domain.usecases.news.SearchNews
import com.wanderlei.newsappcompose.util.Constants.BASE_URL
import com.wanderlei.newsappcompose.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewApi(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}