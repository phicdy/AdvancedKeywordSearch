package com.phicdy.advancedkeywordsearch

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_setting.*


class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setSupportActionBar(bottomAppBar)
        initSearchView()
    }

    private fun initSearchView() {
        searchView.apply {
            requestFocus()

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    clearFocus()
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$query"))
                        startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(
                            this@SettingActivity,
                            getString(R.string.error_activity_not_found),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    return true // Handled the event in the listener, not handle in default SearchView
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true // Handled the event in the listener, not handle in default SearchView
                }

            })

            setOnQueryTextFocusChangeListener { view, hasFocus ->
                if (!hasFocus) {
                    if (query.isEmpty()) {
                        // Close SearchView
                        onActionViewCollapsed()
                    } else {
                        // Not close SearchView, hide the keyboard
                        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as
                                InputMethodManager
                        imm.hideSoftInputFromWindow(view.windowToken, 0)
                    }
                }
            }
        }
    }
}
