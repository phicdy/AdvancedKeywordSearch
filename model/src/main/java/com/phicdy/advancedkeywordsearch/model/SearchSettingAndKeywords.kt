package com.phicdy.advancedkeywordsearch.model

import androidx.room.Embedded
import androidx.room.Relation

data class SearchSettingAndKeywords(
    @Embedded
    val setting: SearchSetting,

    @Relation(parentColumn = "id", entityColumn = "setting_id")
    val keywords: List<ExcludedKeyword>
)
