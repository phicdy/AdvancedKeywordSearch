package com.phicdy.advancedkeywordsearch.data.repository

import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.preferences.SettingPreferences
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class
    ]
)
interface RepositoryComponent {
    fun settingRepository(): SettingRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun settingPreferences(preferences: SettingPreferences): Builder

        @BindsInstance
        fun settingDatabase(database: SearchSettingDatabase): Builder

        fun build(): RepositoryComponent
    }

    companion object {
        fun builder(): Builder = DaggerRepositoryComponent.builder()
    }
}
