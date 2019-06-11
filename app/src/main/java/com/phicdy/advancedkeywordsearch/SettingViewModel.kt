package com.phicdy.advancedkeywordsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phicdy.advancedkeywordsearch.domain.entity.Period
import com.phicdy.advancedkeywordsearch.domain.usecase.SearchUrlOptionUseCase
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository,
    private val searchUrlOptionUseCase: SearchUrlOptionUseCase
) : ViewModel() {

    val searchSetting: Deferred<LiveData<List<SearchSettingAndKeywords>>> by lazy {
        viewModelScope.async(start = CoroutineStart.LAZY) { settingRepository.fetch() }
    }

    suspend fun update(setting: SearchSetting) = coroutineScope {
        settingRepository.update(setting)
    }

    fun generateSearchUrlOption(
        settings: List<SearchSettingAndKeywords>,
        period: Period
    ) =
        searchUrlOptionUseCase.generateSearchUrlOption(settings, period)
}