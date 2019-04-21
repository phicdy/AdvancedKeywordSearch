package com.phicdy.advancedkeywordsearch.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "excluded_keyword",
    foreignKeys = [
        ForeignKey(
            entity = SearchSetting::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("setting_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class ExcludedKeyword(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "setting_id") val settingId: Int,
    val keyword: String
)