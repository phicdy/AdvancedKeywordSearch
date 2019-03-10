package com.phicdy.advancedkeywordsearch.repository

import com.phicdy.advancedkeywordsearch.model.SearchSetting

interface SettingRepository {

    suspend fun fetch(): SearchSetting
}