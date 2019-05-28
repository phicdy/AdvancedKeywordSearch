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
data class ExcludedKeyword(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "setting_id") val settingId: Long = 0,
    val keyword: String
)