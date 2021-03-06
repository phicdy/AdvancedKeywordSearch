package com.phicdy.advancedkeywordsearch.main.addsetting

import androidx.lifecycle.ViewModel
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class AddSettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository
) : ViewModel() {

    suspend fun store(title: String, keywords: List<ExcludedKeyword>) = coroutineScope {
        settingRepository.store(title, keywords)
    }
}
