package com.phicdy.advancedkeywordsearch.main.addsetting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.phicdy.advancedkeywordsearch.main.R

class AddSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_setting_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AddSettingFragment.newInstance())
                .commitNow()
        }
    }

}
