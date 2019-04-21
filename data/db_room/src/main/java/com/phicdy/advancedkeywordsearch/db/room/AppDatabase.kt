package com.phicdy.advancedkeywordsearch.db.room

import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import javax.inject.Inject

/**
 * Implementation class of the interface defined in db module
 */
class AppDatabase @Inject constructor(
    val database: AppRoomDatabase
) : SearchSettingDatabase {

    override fun settings(): List<SearchSettingAndKeywords> {
        return database.searchSettingDao().loadSettingAndKeyword()
    }
}