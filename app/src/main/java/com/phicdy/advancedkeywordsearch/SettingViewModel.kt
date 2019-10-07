package com.phicdy.advancedkeywordsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phicdy.advancedkeywordsearch.domain.entity.Period
import com.phicdy.advancedkeywordsearch.domain.usecase.SearchUrlOptionUseCase
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository,
    private val searchUrlOptionUseCase: SearchUrlOptionUseCase
) : ViewModel() {

    val searchSetting: Deferred<LiveData<List<SearchSettingAndKeywords>>> by lazy {
        viewModelScope.async(start = CoroutineStart.LAZY) { settingRepository.fetch() }
    }

    suspend fun changeDefault(
        tappedId: Long,
        currentList: MutableList<SearchSettingAndKeywords>
    ) = withContext(Dispatchers.IO) {
        val updatedList = mutableListOf<SearchSetting>()
        currentList.forEach {
            if (it.setting.id == tappedId) {
                if (it.setting.defaultEnabled) return@withContext // No change
                updatedList.add(it.setting.copy(defaultEnabled = true))
            } else {
                updatedList.add(it.setting.copy(defaultEnabled = false))
            }
        }
        settingRepository.update(updatedList)
    }

    suspend fun delete(setting: SearchSetting) {
        settingRepository.delete(setting)
    }

    fun generateSearchUrlOption(
        keywords: List<ExcludedKeyword>,
        period: Period
    ) =
        searchUrlOptionUseCase.generateSearchUrlOption(keywords, period)
}