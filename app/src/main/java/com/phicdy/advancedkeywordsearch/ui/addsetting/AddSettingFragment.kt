package com.phicdy.advancedkeywordsearch.ui.addsetting

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.phicdy.advancedkeywordsearch.R
import com.phicdy.advancedkeywordsearch.databinding.AddSettingFragmentBinding

class AddSettingFragment : Fragment() {

    companion object {
        fun newInstance() = AddSettingFragment()
    }

    private lateinit var viewModel: AddSettingViewModel
    private val adapter = ExcludeKeywordListAdapter()

    private val binding: AddSettingFragmentBinding by lazy {
        DataBindingUtil.setContentView<AddSettingFragmentBinding>(activity!!, R.layout.add_setting_fragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.add_setting_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddSettingViewModel::class.java)
        // TODO: Use the ViewModel
        binding.inputKeyword.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE && event?.action != KeyEvent.ACTION_UP) {
                adapter.add(v.text.toString())
                return@setOnEditorActionListener true
            }

            return@setOnEditorActionListener false
        }
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@AddSettingFragment.adapter
        }
    }
}
