package com.phicdy.advancedkeywordsearch.db

import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

interface SearchSettingDatabase {
    fun settings(): List<SearchSettingAndKeywords>
    fun store(title: String, keywords: List<ExcludedKeyword>)
    fun update(setting: SearchSetting)
}