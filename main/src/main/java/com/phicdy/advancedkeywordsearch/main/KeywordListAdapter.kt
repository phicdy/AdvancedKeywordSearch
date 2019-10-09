package com.phicdy.advancedkeywordsearch.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.phicdy.advancedkeywordsearch.main.databinding.ItemExcludedKeywordBinding
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword

class KeywordListAdapter :
    ListAdapter<ExcludedKeyword, KeywordListAdapter.KeywordViewHolder>(
        KEYWORD_DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordViewHolder {
        val binding =
            ItemExcludedKeywordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KeywordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KeywordViewHolder, position: Int) {
        holder.binding.keyword.text = getItem(position).keyword
    }

    class KeywordViewHolder(
        val binding: ItemExcludedKeywordBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

private val KEYWORD_DIFF_CALLBACK = object : DiffUtil.ItemCallback<ExcludedKeyword>() {

    override fun areItemsTheSame(oldItem: ExcludedKeyword, newItem: ExcludedKeyword): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ExcludedKeyword, newItem: ExcludedKeyword): Boolean {
        return oldItem == newItem
    }
}

