package com.phicdy.advancedkeywordsearch.domain.usecase

import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import javax.inject.Inject

class SearchUrlOptionUseCase @Inject constructor() {


    fun generateSearchUrlOption(settings: List<SearchSettingAndKeywords>): String {
        val temp = StringBuffer()
        settings.forEach {
            if (!it.setting.defaultEnabled) return@forEach
            it.keywords.forEach { keyword ->
                temp.append("+-")
                temp.append(keyword.keyword)
            }
        }
        return temp.toString()
    }
}