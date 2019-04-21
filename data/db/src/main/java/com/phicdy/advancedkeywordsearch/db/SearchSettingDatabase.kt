package com.phicdy.advancedkeywordsearch.db

import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

interface SearchSettingDatabase {
    fun settings(): List<SearchSettingAndKeywords>
}