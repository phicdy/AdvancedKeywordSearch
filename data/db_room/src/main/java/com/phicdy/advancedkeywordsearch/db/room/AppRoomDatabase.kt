package com.phicdy.advancedkeywordsearch.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.phicdy.advancedkeywordsearch.db.room.dao.SearchSettingDao
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSetting

@Database(
    entities = [SearchSetting::class, ExcludedKeyword::class],
    version = 1
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun searchSettingDao(): SearchSettingDao
}

