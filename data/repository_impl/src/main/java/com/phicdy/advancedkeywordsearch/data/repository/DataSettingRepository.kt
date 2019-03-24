package com.phicdy.advancedkeywordsearch.data.repository

import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.preferences.SettingPreferences
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataSettingRepository @Inject constructor(val preferences: SettingPreferences) : SettingRepository {
    override suspend fun fetch(): SearchSetting = withContext(Dispatchers.IO) {
        return@withContext SearchSetting(preferences.excludedWordings())
    }
}