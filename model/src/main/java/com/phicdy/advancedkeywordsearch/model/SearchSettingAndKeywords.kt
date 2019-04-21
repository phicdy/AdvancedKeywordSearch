package com.phicdy.advancedkeywordsearch.model

import androidx.room.Embedded
import androidx.room.Relation

class SearchSettingAndKeywords {
    @Embedded
    lateinit var setting: SearchSetting

    @Relation(parentColumn = "id", entityColumn = "setting_id")
    lateinit var keywords: List<ExcludedKeyword>
}