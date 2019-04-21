package com.phicdy.advancedkeywordsearch.db.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords

@Dao
interface SearchSettingDao {

    @Insert
    fun insertSetting(vararg settings: SearchSetting)

    @Insert
    fun insertKeyword(vararg keywords: ExcludedKeyword)

    @Delete
    fun deleteSetting(vararg settings: SearchSetting)

    @Transaction
    @Query("SELECT * FROM search_setting")
    fun loadSettingAndKeyword(): List<SearchSettingAndKeywords>
}