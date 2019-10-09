package com.phicdy.advancedkeywordsearch.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.phicdy.advancedkeywordsearch.db.room.dao.ExcludeKeywordDao
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword

@Database(
    entities = [ExcludedKeyword::class],
    version = 1
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun excludedKeywordDao(): ExcludeKeywordDao
}

