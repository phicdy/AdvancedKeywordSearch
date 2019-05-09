package com.phicdy.advancedkeywordsearch.ui.addsetting

import androidx.lifecycle.ViewModel
import com.phicdy.advancedkeywordsearch.repository.SettingRepository
import javax.inject.Inject

class AddSettingViewModel @Inject constructor(
    val settingRepository: SettingRepository
) : ViewModel() {

}
