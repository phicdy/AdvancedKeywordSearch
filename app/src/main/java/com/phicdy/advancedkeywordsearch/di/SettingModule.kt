package com.phicdy.advancedkeywordsearch.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phicdy.advancedkeywordsearch.main.MainActivity
import com.phicdy.advancedkeywordsearch.main.SettingViewModel
import com.phicdy.advancedkeywordsearch.main.SettingViewModelFactory
import com.phicdy.advancedkeywordsearch.main.addsetting.AddSettingFragment
import com.phicdy.advancedkeywordsearch.main.addsetting.AddSettingViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SettingModule {

    @ContributesAndroidInjector
    abstract fun contributeSettingActivity(): MainActivity

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