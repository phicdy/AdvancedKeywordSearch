package com.phicdy.advancedkeywordsearch.di

import com.phicdy.advancedkeywordsearch.AdvancedKeyWordSearchApplication
import com.phicdy.advancedkeywordsearch.preferences.PreferencesComponent
import com.phicdy.advancedkeywordsearch.preferences.SettingPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object PreferencesComponentModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideSettingRepository(
        preferencesComponent: PreferencesComponent
    ): SettingPreferences {
        return preferencesComponent.settingPreferences()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun providePreferencesComponent(app: AdvancedKeyWordSearchApplication): PreferencesComponent {
        return PreferencesComponent.builder()
            .context(app)
            .build()
    }
}