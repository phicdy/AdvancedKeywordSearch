package com.phicdy.advancedkeywordsearch.preferences

import android.content.SharedPreferences

class LocalSettingPreferences(preferences: SharedPreferences) : SettingPreferences {
    override fun excludedWordings(): List<String> {
        return listOf("aaa", "bbb")
    }
}