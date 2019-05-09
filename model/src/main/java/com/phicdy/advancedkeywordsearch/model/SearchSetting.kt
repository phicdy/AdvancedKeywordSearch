package com.phicdy.advancedkeywordsearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_setting")
data class SearchSetting(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val title: String
)
