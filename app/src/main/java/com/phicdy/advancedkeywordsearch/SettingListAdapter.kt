package com.phicdy.advancedkeywordsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phicdy.advancedkeywordsearch.databinding.ItemSearchSettingBinding
import com.phicdy.advancedkeywordsearch.model.SearchSetting

class SettingListAdapter : RecyclerView.Adapter<SettingListAdapter.SearchSettingViewHolder>() {

    private val items = mutableListOf<SearchSetting>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSettingViewHolder {
        val listItemBinding = ItemSearchSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchSettingViewHolder(listItemBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchSettingViewHolder, position: Int) {
        holder.binding.title.text = items[position].title
    }

    fun add(searchSettings: List<SearchSetting>) {
        items.addAll(searchSettings)
        notifyDataSetChanged()
    }

    class SearchSettingViewHolder(
        val binding: ItemSearchSettingBinding
    ) : RecyclerView.ViewHolder(binding.root)
}