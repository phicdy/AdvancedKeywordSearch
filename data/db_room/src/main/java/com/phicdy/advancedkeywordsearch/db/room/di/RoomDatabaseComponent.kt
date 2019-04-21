package com.phicdy.advancedkeywordsearch.db.room.di

import android.content.Context
import com.phicdy.advancedkeywordsearch.db.SearchSettingDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RoomDatabaseModule::class
    ]
)
interface RoomDatabaseComponent {
    fun settingDatabase(): SearchSettingDatabase

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): RoomDatabaseComponent
    }

    companion object {
        fun builder(): Builder = DaggerRoomDatabaseComponent.builder()
    }
}