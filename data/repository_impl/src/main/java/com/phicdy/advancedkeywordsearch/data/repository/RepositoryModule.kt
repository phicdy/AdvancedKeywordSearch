package com.phicdy.advancedkeywordsearch.data.repository

import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule.Providers::class])
internal abstract class RepositoryModule {
    @Binds
    abstract fun settingRepository(impl: DataSettingRepository): SettingRepository

    @Module
    internal object Providers
}
