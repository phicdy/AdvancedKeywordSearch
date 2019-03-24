package com.phicdy.advancedkeywordsearch.preferences

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        PreferencesModule::class
    ]
)
interface PreferencesComponent {
    fun settingPreferences(): SettingPreferences

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): PreferencesComponent
    }

    companion object {
        fun builder(): Builder = DaggerPreferencesComponent.builder()
    }
}