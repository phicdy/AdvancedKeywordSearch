package com.phicdy.advancedkeywordsearch.repository

import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

interface SettingRepository {

    suspend fun fetch(): List<SearchSettingAndKeywords>
    suspend fun store(title: String, keywords: List<ExcludedKeyword>)
}