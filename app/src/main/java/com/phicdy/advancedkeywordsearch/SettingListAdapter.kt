package com.phicdy.advancedkeywordsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.phicdy.advancedkeywordsearch.databinding.ItemExcludedKeywordBinding
import com.phicdy.advancedkeywordsearch.databinding.ItemSearchSettingBinding
import com.phicdy.advancedkeywordsearch.model.ExcludedKeyword
import com.phicdy.advancedkeywordsearch.model.SearchSettingAndKeywords
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SettingListAdapter(
    private val settingViewModel: SettingViewModel,
    private val coroutineScope: CoroutineScope
) : ListAdapter<SearchSettingAndKeywords, SettingListAdapter.SearchSettingViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSettingViewHolder {
        val listItemBinding =
            ItemSearchSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchSettingViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: SearchSettingViewHolder, position: Int) {
        val setting = getItem(position).setting
        holder.binding.title.text = setting.title

        holder.binding.card.apply {
            setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.binding.root.context,
                    if (setting.defaultEnabled) R.color.card_background_enabled else R.color.card_background
                )
            )
            setOnClickListener {
                coroutineScope.launch {
                    settingViewModel.changeDefault(setting.id, currentList)
                }
            }
        }

        holder.binding.delete.setImageResource(
            if (setting.defaultEnabled) R.drawable.ic_delete_white else R.drawable.ic_delete
        )
        holder.binding.delete.setOnClickListener {
            AlertDialog.Builder(holder.binding.root.context)
                .setTitle(R.string.alert_delete_title)
                .setMessage(R.string.alert_delete_message)
                .setPositiveButton(
                    R.string.alert_delete_positive
                ) { _, _ -> coroutineScope.launch { settingViewModel.delete(setting) } }
                .setNegativeButton(
                    R.string.alert_delete_negative
                ) { _, _ -> }
                .create()
                .show()
        }

        holder.binding.title.setCardTextColor(setting.defaultEnabled)
        holder.binding.excludedKeywordsLabel.setCardTextColor(setting.defaultEnabled)

        val flexboxLayoutManager = FlexboxLayoutManager(holder.binding.root.context).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }
        val adapter = KeywordListAdapter()
        holder.binding.recyclerView.apply {
            this.adapter = adapter
            layoutManager = flexboxLayoutManager
        }
        adapter.submitList(getItem(position).keywords)
    }

    class SearchSettingViewHolder(
        val binding: ItemSearchSettingBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

fun TextView.setCardTextColor(defaultEnabled: Boolean) {
    setTextColor(
        ContextCompat.getColor(
            context,
            if (defaultEnabled) R.color.textPrimary_white else R.color.textPrimary
        )
    )
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SearchSettingAndKeywords>() {

    override fun areItemsTheSame(
        oldItem: SearchSettingAndKeywords,
        newItem: SearchSettingAndKeywords
    ): Boolean {
        return oldItem.setting.id == newItem.setting.id
    }

    override fun areContentsTheSame(
        oldItem: SearchSettingAndKeywords,
        newItem: SearchSettingAndKeywords
    ): Boolean {
        return oldItem == newItem
    }
}

class KeywordListAdapter :
    ListAdapter<ExcludedKeyword, KeywordListAdapter.KeywordViewHolder>(KEYWORD_DIFF_CALLBACK) {

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

