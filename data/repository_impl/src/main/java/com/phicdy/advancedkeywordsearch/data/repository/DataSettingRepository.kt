package com.phicdy.advancedkeywordsearch.data.repository

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
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

    override suspend fun fetch(): LiveData<List<SearchSettingAndKeywords>> = withContext(Dispatchers.IO) {
        return@withContext database.settings()
    }

    override suspend fun store(title: String, keywords: List<ExcludedKeyword>) = withContext(Dispatchers.IO) {
        database.store(title, keywords)
    }

    override suspend fun update(settings: List<SearchSetting>) = withContext(Dispatchers.IO) {
        database.update(settings)
    }

    override suspend fun delete(setting: SearchSetting) = withContext(Dispatchers.IO) {
        database.delete(setting)
    }
}