package com.phicdy.advancedkeywordsearch.di

import com.phicdy.advancedkeywordsearch.data.repository.RepositoryComponent
import com.phicdy.advancedkeywordsearch.preferences.SettingPreferences
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryComponentModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideSettingRepository(
        repositoryComponent: RepositoryComponent
    ): SettingRepository {
        return repositoryComponent.settingRepository()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideRepositoryComponent(
        preferences: SettingPreferences
    ): RepositoryComponent {
        return RepositoryComponent.builder()
            .settingDatabase(preferences)
            .build()
    }
}