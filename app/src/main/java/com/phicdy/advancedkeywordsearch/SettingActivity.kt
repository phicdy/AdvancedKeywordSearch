package com.phicdy.advancedkeywordsearch

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_setting.*


class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_setting, menu)

        (menu.findItem(R.id.search).actionView as SearchView).apply {
            val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
            setSearchableInfo(searchManager.getSearchableInfo(componentName))

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    clearFocus()
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$query"))
                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(this@SettingActivity, getString(R.string.error_activity_not_found), Toast.LENGTH_SHORT).show()
                    }
                    return true // Handled the event in the listener, not handle in default SearchView
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true // Handled the event in the listener, not handle in default SearchView
                }

            })
        }

        return true
    }
}
