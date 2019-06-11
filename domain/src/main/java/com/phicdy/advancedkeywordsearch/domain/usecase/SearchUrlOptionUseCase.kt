package com.phicdy.advancedkeywordsearch.domain.usecase

import com.phicdy.advancedkeywordsearch.domain.entity.Period
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import javax.inject.Inject

class SearchUrlOptionUseCase @Inject constructor() {


    fun generateSearchUrlOption(
        settings: List<SearchSettingAndKeywords>,
        period: Period
    ): String {
        val temp = StringBuffer()
        settings.forEach {
            if (!it.setting.defaultEnabled) return@forEach
            it.keywords.forEach { keyword ->
                temp.append("+-")
                temp.append(keyword.keyword)
            }
        }
        temp.append(
            when (period) {
                Period.NO_LIMIT -> ""
                Period.ONE_HOUR_OR_LESS -> "&tbs=qdr:h"
                Period.TWENTY_FOUR_HOURS_OR_LESS -> "&tbs=qdr:d"
                Period.ONE_WEEK_OR_LESS -> "&tbs=qdr:w"
                Period.ONE_MONTH_OR_LESS -> "&tbs=qdr:m"
                Period.ONE_YEAR_OR_LESS -> "&tbs=qdr:y"
            }
        )
        return temp.toString()
    }
}