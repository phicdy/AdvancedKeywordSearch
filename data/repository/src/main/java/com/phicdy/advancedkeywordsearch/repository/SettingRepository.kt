package com.phicdy.advancedkeywordsearch.repository

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword

interface SettingRepository {

    suspend fun fetch(): LiveData<List<ExcludedKeyword>>
    suspend fun store(title: String, keywords: List<ExcludedKeyword>)
}