package com.wanderlei.newsappcompose.domain.usecases

import com.wanderlei.newsappcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}