package com.phicdy.advancedkeywordsearch

import com.phicdy.advancedkeywordsearch.di.createAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class AdvancedKeyWordSearchApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = createAppComponent()
}