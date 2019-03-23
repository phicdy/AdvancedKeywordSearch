package com.phicdy.advancedkeywordsearch.di

import android.app.Application
import com.phicdy.advancedkeywordsearch.AdvancedKeyWordSearchApplication
import dagger.BindsInstance
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
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: AdvancedKeyWordSearchApplication)
}

