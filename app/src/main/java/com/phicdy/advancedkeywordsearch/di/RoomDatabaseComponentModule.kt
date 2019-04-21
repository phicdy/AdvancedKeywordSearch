package com.phicdy.advancedkeywordsearch.di

import com.phicdy.advancedkeywordsearch.AdvancedKeyWordSearchApplication
import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import com.phicdy.advancedkeywordsearch.db.room.di.RoomDatabaseComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RoomDatabaseComponentModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideSettingDatabase(
        roomDatabaseComponent: RoomDatabaseComponent
    ): SearchSettingDatabase {
        return roomDatabaseComponent.settingDatabase()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideRoomDatabaseComponent(app: AdvancedKeyWordSearchApplication): RoomDatabaseComponent {
        return RoomDatabaseComponent.builder()
            .context(app)
            .build()
    }
}