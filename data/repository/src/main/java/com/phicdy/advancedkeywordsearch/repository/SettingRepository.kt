package com.phicdy.advancedkeywordsearch.repository

import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

interface SettingRepository {

    suspend fun fetch(): List<SearchSettingAndKeywords>
}