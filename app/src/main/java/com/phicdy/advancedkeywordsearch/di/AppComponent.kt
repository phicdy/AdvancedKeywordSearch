package com.phicdy.advancedkeywordsearch.di

import com.phicdy.advancedkeywordsearch.AdvancedKeyWordSearchApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        SettingModule::class,
        RepositoryComponentModule::class,
        RoomDatabaseComponentModule::class,
        PreferencesComponentModule::class
    ]
)
interface AppComponent : AndroidInjector<AdvancedKeyWordSearchApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AdvancedKeyWordSearchApplication>()
}

