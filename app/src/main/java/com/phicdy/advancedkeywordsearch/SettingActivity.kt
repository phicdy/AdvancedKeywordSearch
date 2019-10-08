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
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.phicdy.advancedkeywordsearch.databinding.ActivitySettingBinding
import com.phicdy.advancedkeywordsearch.domain.entity.Period
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

    private val adapter by lazy {
        KeywordListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.bottomAppBar)
        initRecyclerView()
        initSearchView()
        initFab()
    }

    override fun onStart() {
        super.onStart()
        launch {
            settingViewModel.searchSetting.await().observe(this@SettingActivity, Observer {
                adapter.submitList(it.keywords)
            })
        }
    }

    private fun initRecyclerView() {
        val flexboxLayoutManager = FlexboxLayoutManager(binding.root.context).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }
        binding.recyclerView.apply {
            adapter = this@SettingActivity.adapter
            layoutManager = flexboxLayoutManager
        }
    }

    private fun initSearchView() {
        binding.searchView.apply {
            requestFocus()

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    clearFocus()
                    try {
                        val period = when (binding.rgPeriod.checkedRadioButtonId) {
                            R.id.rbNoLimit -> Period.NO_LIMIT
                            R.id.rb1hourOrLess -> Period.ONE_HOUR_OR_LESS
                            R.id.rb24hoursOrLess -> Period.TWENTY_FOUR_HOURS_OR_LESS
                            R.id.rb1weekOrLess -> Period.ONE_WEEK_OR_LESS
                            R.id.rb1monthOrLess -> Period.ONE_MONTH_OR_LESS
                            R.id.rb1yearOrLess -> Period.ONE_YEAR_OR_LESS
                            else -> Period.NO_LIMIT
                        }
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(
                                "https://www.google.com/search?q=$query" +
                                        settingViewModel.generateSearchUrlOption(
                                            adapter.currentList,
                                            period
                                        )
                            )
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
