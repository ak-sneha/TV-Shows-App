package com.example.tvshowsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshowsapp.databinding.ShowsListItemBinding

class ShowsListAdapter(val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<ShowsListAdapter.ItemHolder>() {

    private var showsList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflatedView =
            ShowsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(inflatedView)
    }

    override fun getItemCount() = showsList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        with(showsList[position]) {
            holder.binding.tvName.text = this
            holder.binding.rootLayout.setOnClickListener { clickListener(this) }
        }
    }

    class ItemHolder(b: ShowsListItemBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ShowsListItemBinding = b
    }

    fun add(list: MutableList<String>) {
        showsList.clear()
        showsList.addAll(list)
        notifyDataSetChanged()
    }
}