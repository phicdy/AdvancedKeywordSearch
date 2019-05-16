package com.phicdy.advancedkeywordsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phicdy.advancedkeywordsearch.databinding.ItemSearchSettingBinding
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SettingListAdapter(
    private val settingViewModel: SettingViewModel,
    private val coroutineScope: CoroutineScope
) : RecyclerView.Adapter<SettingListAdapter.SearchSettingViewHolder>() {

    private val items = mutableListOf<SearchSettingAndKeywords>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSettingViewHolder {
        val listItemBinding = ItemSearchSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchSettingViewHolder(listItemBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchSettingViewHolder, position: Int) {
        val setting = items[position].setting
        holder.binding.title.text = setting.title
        holder.binding.switchEnabled.apply {
            isChecked = setting.defaultEnabled
            setOnCheckedChangeListener { _, isChecked ->
                coroutineScope.launch { settingViewModel.update(setting.copy(setting.id, setting.title, isChecked)) }
            }
        }
    }

    fun set(searchSettings: List<SearchSettingAndKeywords>) {
        items.clear()
        items.addAll(searchSettings)
        notifyDataSetChanged()
    }

    class SearchSettingViewHolder(
        val binding: ItemSearchSettingBinding
    ) : RecyclerView.ViewHolder(binding.root)
}