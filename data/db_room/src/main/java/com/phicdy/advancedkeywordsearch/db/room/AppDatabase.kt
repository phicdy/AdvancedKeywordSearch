package com.phicdy.advancedkeywordsearch.db.room

import androidx.lifecycle.LiveData
import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import javax.inject.Inject

/**
 * Implementation class of the interface defined in db module
 */
class AppDatabase @Inject constructor(
    val database: AppRoomDatabase
) : SearchSettingDatabase {

    override fun settings(): LiveData<SearchSettingAndKeywords> {
        return database.searchSettingDao().loadSettingAndKeyword()
    }

    override fun store(title: String, keywords: List<ExcludedKeyword>) {
        val id = database.searchSettingDao()
            .insertSetting(SearchSetting(title = title, defaultEnabled = false))
        val insertKeywords = keywords.map { ExcludedKeyword(it.id, id, it.keyword) }
        database.searchSettingDao().insertKeyword(*insertKeywords.toTypedArray())
    }

    override fun update(settings: List<SearchSetting>) {
        database.searchSettingDao().updateSetting(*settings.toTypedArray())
    }

    override fun delete(setting: SearchSetting) {
        database.searchSettingDao().deleteSetting(setting)
    }
}