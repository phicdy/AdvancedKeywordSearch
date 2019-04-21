package com.phicdy.advancedkeywordsearch.db.room.di

import android.content.Context
import androidx.room.Room
import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.db.room.AppDatabase
import com.phicdy.advancedkeywordsearch.db.room.AppRoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RoomDatabaseModule.Providers::class])
internal abstract class RoomDatabaseModule {
    @Binds
    abstract fun settingDatabase(impl: AppDatabase): SearchSettingDatabase

    @Module
    internal object Providers {
        @Singleton
        @JvmStatic
        @Provides
        fun roomDatabase(
            context: Context
        ): AppRoomDatabase {
            return Room.databaseBuilder(
                context,
                AppRoomDatabase::class.java,
                "app.db"
            ).build()
        }
    }
}
