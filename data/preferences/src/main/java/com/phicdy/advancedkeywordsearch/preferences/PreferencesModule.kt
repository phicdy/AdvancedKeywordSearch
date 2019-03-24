package com.phicdy.advancedkeywordsearch.preferences

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [PreferencesModule.Providers::class])
internal abstract class PreferencesModule {
    @Binds
    abstract fun settingPreferences(impl: LocalSettingPreferences): SettingPreferences

    @Module
    internal object Providers {
        @Singleton
        @JvmStatic
        @Provides
        fun prefrecnes(
            context: Context
        ): LocalSettingPreferences {
            return LocalSettingPreferences(
                context.getSharedPreferences("setting", Context.MODE_PRIVATE)
            )
        }
    }
}
