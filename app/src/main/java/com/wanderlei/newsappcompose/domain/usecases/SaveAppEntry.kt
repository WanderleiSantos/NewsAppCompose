package com.wanderlei.newsappcompose.domain.usecases

import com.wanderlei.newsappcompose.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}