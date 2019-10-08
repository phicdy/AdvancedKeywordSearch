package com.phicdy.advancedkeywordsearch.db

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

interface SearchSettingDatabase {
    fun settings(): LiveData<SearchSettingAndKeywords>
    fun store(title: String, keywords: List<ExcludedKeyword>)
    fun update(settings: List<SearchSetting>)
    fun delete(setting: SearchSetting)
}