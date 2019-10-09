package com.phicdy.advancedkeywordsearch.main.addsetting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phicdy.advancedkeywordsearch.main.databinding.ItemAddedWordBinding

class ExcludeKeywordListAdapter :
    RecyclerView.Adapter<ExcludeKeywordListAdapter.ExcludeKeywordViewHolder>() {

    val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcludeKeywordViewHolder {
        val listItemBinding =
            ItemAddedWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExcludeKeywordViewHolder(listItemBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ExcludeKeywordViewHolder, position: Int) {
        holder.binding.word.text = items[position]
    }

    fun add(keyword: String) {
        items.add(keyword)
        notifyDataSetChanged()
    }

    class ExcludeKeywordViewHolder(
        val binding: ItemAddedWordBinding
    ) : RecyclerView.ViewHolder(binding.root)
}