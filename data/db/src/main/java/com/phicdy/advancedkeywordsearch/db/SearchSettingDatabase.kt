package com.phicdy.advancedkeywordsearch.db

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword

interface SearchSettingDatabase {
    fun excludedKeywords(): LiveData<List<ExcludedKeyword>>
    fun store(title: String, keywords: List<ExcludedKeyword>)
}