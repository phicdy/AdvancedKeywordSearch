package com.phicdy.advancedkeywordsearch.data.repository

import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import com.phicdy.advancedkeywordsearch.preferences.SettingPreferences
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataSettingRepository @Inject constructor(
    val preferences: SettingPreferences,
    val database: SearchSettingDatabase
) : SettingRepository {
    override suspend fun fetch(): List<SearchSettingAndKeywords> = withContext(Dispatchers.IO) {
        return@withContext database.settings()
    }
}