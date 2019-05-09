package com.phicdy.advancedkeywordsearch.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phicdy.advancedkeywordsearch.SettingActivity
import com.phicdy.advancedkeywordsearch.SettingViewModel
import com.phicdy.advancedkeywordsearch.SettingViewModelFactory
import com.phicdy.advancedkeywordsearch.ui.addsetting.AddSettingFragment
import com.phicdy.advancedkeywordsearch.ui.addsetting.AddSettingViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SettingModule {

    @ContributesAndroidInjector
    abstract fun contributeSettingActivity(): SettingActivity

    @ContributesAndroidInjector
    abstract fun contributeAddSettingFragment(): AddSettingFragment

    @Binds
    @IntoMap
    @ViewModelKey(SettingViewModel::class)
    abstract fun bindSettingViewModel(viewModel: SettingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddSettingViewModel::class)
    abstract fun bindAddSettingViewModel(viewModel: AddSettingViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: SettingViewModelFactory): ViewModelProvider.Factory
}