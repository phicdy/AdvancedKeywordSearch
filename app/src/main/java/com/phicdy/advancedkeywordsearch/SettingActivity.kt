package com.phicdy.advancedkeywordsearch

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.phicdy.advancedkeywordsearch.databinding.ActivitySettingBinding
import com.phicdy.advancedkeywordsearch.ui.addsetting.AddSettingActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class SettingActivity : DaggerAppCompatActivity(), CoroutineScope {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val binding: ActivitySettingBinding by lazy {
        DataBindingUtil.setContentView<ActivitySettingBinding>(this, R.layout.activity_setting)
    }

    private val settingViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SettingViewModel::class.java)
    }

    private val adapter = SettingListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.bottomAppBar)
        initRecyclerView()
        initSearchView()
        initFab()
        settingViewModel.searchSetting.observe(this, Observer {
            adapter.add(it)
        })
        launch {
            settingViewModel.init()
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@SettingActivity)
            adapter = this@SettingActivity.adapter
        }
    }

    private fun initSearchView() {
        binding.searchView.apply {
            requestFocus()

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    clearFocus()
                    try {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/search?q=$query+-いかがでしたか&tbs=qdr:y")
                        )
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
                    // Hide the keyboard
                    val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as
                            InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }
            }
        }
    }

    private fun initFab() {
        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddSettingActivity::class.java))
        }
    }

}
