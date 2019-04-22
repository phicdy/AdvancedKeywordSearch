package com.phicdy.advancedkeywordsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SettingViewModel @Inject constructor(
    val settingRepository: SettingRepository
) : ViewModel() {

    private val _searchSettings = MutableLiveData<List<SearchSettingAndKeywords>>()
    val searchSetting: LiveData<List<SearchSettingAndKeywords>>
        get() = _searchSettings

    suspend fun init() = coroutineScope {
        val setting = settingRepository.fetch()
        if (setting.isEmpty()) return@coroutineScope
        _searchSettings.postValue(setting)
    }

}