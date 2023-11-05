package com.wanderlei.newsappcompose.domain.usecases.app_entry

import com.wanderlei.newsappcompose.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}