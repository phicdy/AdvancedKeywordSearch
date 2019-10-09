package com.phicdy.advancedkeywordsearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "excluded_keyword")
data class ExcludedKeyword(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val keyword: String
)