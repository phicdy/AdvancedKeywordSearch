package com.phicdy.advancedkeywordsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.phicdy.advancedkeywordsearch.databinding.ItemSearchSettingBinding
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SettingListAdapter(
    private val settingViewModel: SettingViewModel,
    private val coroutineScope: CoroutineScope
) : ListAdapter<SearchSettingAndKeywords, SettingListAdapter.SearchSettingViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSettingViewHolder {
        val listItemBinding = ItemSearchSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchSettingViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: SearchSettingViewHolder, position: Int) {
        val setting = getItem(position).setting
        holder.binding.title.text = setting.title
        holder.binding.switchEnabled.apply {
            isChecked = setting.defaultEnabled
            setOnCheckedChangeListener { _, isChecked ->
                coroutineScope.launch { settingViewModel.update(setting.copy(setting.id, setting.title, isChecked)) }
            }
        }
    }

    class SearchSettingViewHolder(
        val binding: ItemSearchSettingBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SearchSettingAndKeywords>() {

    override fun areItemsTheSame(oldItem: SearchSettingAndKeywords, newItem: SearchSettingAndKeywords): Boolean {
        return oldItem.setting.id == newItem.setting.id
    }

    override fun areContentsTheSame(oldItem: SearchSettingAndKeywords, newItem: SearchSettingAndKeywords): Boolean {
        return oldItem.setting == newItem.setting && oldItem.keywords == newItem.keywords
    }

}
