package com.phicdy.advancedkeywordsearch.db.room

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import javax.inject.Inject

/**
 * Implementation class of the interface defined in db module
 */
class AppDatabase @Inject constructor(
    val database: AppRoomDatabase
) : SearchSettingDatabase {

    override fun excludedKeywords(): LiveData<List<ExcludedKeyword>> {
        return database.excludedKeywordDao().loadKeywords()
    }

    override fun store(title: String, keywords: List<ExcludedKeyword>) {
        val insertKeywords = keywords.map { ExcludedKeyword(it.id, it.keyword) }
        database.excludedKeywordDao().insertKeyword(*insertKeywords.toTypedArray())
    }
}