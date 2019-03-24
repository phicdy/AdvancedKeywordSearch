package com.phicdy.advancedkeywordsearch

import android.util.Log
import androidx.lifecycle.ViewModel
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SettingViewModel @Inject constructor(
    val settingRepository: SettingRepository
) : ViewModel() {

    suspend fun init() = coroutineScope {
        val setting = settingRepository.fetch()
        Log.d("aaaa", setting.toString())
    }
}