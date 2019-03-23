package com.phicdy.advancedkeywordsearch.di

import com.phicdy.advancedkeywordsearch.AdvancedKeyWordSearchApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        RepositoryComponentModule::class
    ]
)
interface AppComponent : AndroidInjector<AdvancedKeyWordSearchApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AdvancedKeyWordSearchApplication>()
}

