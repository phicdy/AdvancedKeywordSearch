package com.phicdy.advancedkeywordsearch.repository

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

interface SettingRepository {

    suspend fun fetch(): LiveData<List<SearchSettingAndKeywords>>
    suspend fun store(title: String, keywords: List<ExcludedKeyword>)
    suspend fun update(setting: SearchSetting)
}