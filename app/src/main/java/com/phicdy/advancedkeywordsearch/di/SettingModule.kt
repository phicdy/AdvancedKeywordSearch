package com.phicdy.advancedkeywordsearch.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phicdy.advancedkeywordsearch.SettingActivity
import com.phicdy.advancedkeywordsearch.SettingViewModel
import com.phicdy.advancedkeywordsearch.SettingViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SettingModule {

    @ContributesAndroidInjector
    abstract fun contributeSettingActivity(): SettingActivity

    @Binds
    @IntoMap
    @ViewModelKey(SettingViewModel::class)
    abstract fun bindMainViewModel(viewModel: SettingViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: SettingViewModelFactory): ViewModelProvider.Factory
}