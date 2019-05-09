package com.phicdy.advancedkeywordsearch.ui.addsetting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phicdy.advancedkeywordsearch.databinding.ItemSearchSettingBinding

class ExcludeKeywordListAdapter : RecyclerView.Adapter<ExcludeKeywordListAdapter.ExcludeKeywordViewHolder>() {

    val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcludeKeywordViewHolder {
        val listItemBinding = ItemSearchSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExcludeKeywordViewHolder(listItemBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ExcludeKeywordViewHolder, position: Int) {
        holder.binding.title.text = items[position]
    }

    fun add(keyword: String) {
        items.add(keyword)
        notifyDataSetChanged()
    }

    class ExcludeKeywordViewHolder(
        val binding: ItemSearchSettingBinding
    ) : RecyclerView.ViewHolder(binding.root)
}