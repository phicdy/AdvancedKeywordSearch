package com.phicdy.advancedkeywordsearch.db.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword

@Dao
interface SearchSettingDao {

    @Insert
    fun insertKeyword(vararg keywords: ExcludedKeyword)

    @Transaction
    @Query("SELECT * FROM excluded_keyword")
    fun loadSettingAndKeyword(): LiveData<List<ExcludedKeyword>>
}