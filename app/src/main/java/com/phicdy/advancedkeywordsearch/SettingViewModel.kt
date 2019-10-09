package com.phicdy.advancedkeywordsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phicdy.advancedkeywordsearch.domain.entity.Period
import com.phicdy.advancedkeywordsearch.domain.usecase.SearchUrlOptionUseCase
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import javax.inject.Inject

class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository,
    private val searchUrlOptionUseCase: SearchUrlOptionUseCase
) : ViewModel() {

    val searchSetting: Deferred<LiveData<SearchSettingAndKeywords>> by lazy {
        viewModelScope.async(start = CoroutineStart.LAZY) { settingRepository.fetch() }
    }

    fun generateSearchUrlOption(
        keywords: List<ExcludedKeyword>,
        period: Period
    ) =
        searchUrlOptionUseCase.generateSearchUrlOption(keywords, period)
}