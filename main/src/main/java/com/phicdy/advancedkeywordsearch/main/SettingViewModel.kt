package com.phicdy.advancedkeywordsearch.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phicdy.advancedkeywordsearch.domain.entity.Period
import com.phicdy.advancedkeywordsearch.domain.usecase.SearchUrlOptionUseCase
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import javax.inject.Inject

class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository,
    private val searchUrlOptionUseCase: SearchUrlOptionUseCase
) : ViewModel() {

    val keywords: Deferred<LiveData<List<ExcludedKeyword>>> by lazy {
        viewModelScope.async(start = CoroutineStart.LAZY) { settingRepository.fetch() }
    }

    fun fetchSetting() {

    }

    fun generateSearchUrlOption(
        keywords: List<ExcludedKeyword>,
        period: Period
    ) =
        searchUrlOptionUseCase.generateSearchUrlOption(keywords, period)
}