package com.phicdy.advancedkeywordsearch.db

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

interface SearchSettingDatabase {
    fun settings(): LiveData<List<SearchSettingAndKeywords>>
    fun store(title: String, keywords: List<ExcludedKeyword>)
    fun update(setting: SearchSetting)
}