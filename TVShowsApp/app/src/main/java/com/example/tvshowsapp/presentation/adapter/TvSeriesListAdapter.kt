package com.example.tvshowsapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.domain.TVSeries
import com.example.tvshowsapp.databinding.ShowsListItemBinding

class TvSeriesListAdapter(val context: Context, val clickListener: (TVSeries) -> Unit) :
    RecyclerView.Adapter<TvSeriesListAdapter.ItemHolder>() {

    private var showsList = mutableListOf<TVSeries>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflatedView =
            ShowsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(inflatedView)
    }

    override fun getItemCount() = showsList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        with(showsList[position]) {
            holder.binding.tvName.text = this.name ?: ""
            holder.binding.tvSummary.text = HtmlCompat.fromHtml(this.summary ?: "", 0)
            this.image?.medium?.let {
                Glide.with(context)
                    .load(it)
                    .into(holder.binding.ivPoster)
            }
            holder.binding.rootLayout.setOnClickListener { clickListener(this) }
        }
    }

    class ItemHolder(b: ShowsListItemBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ShowsListItemBinding = b
    }

    fun add(list: MutableList<TVSeries>) {
        showsList.clear()
        showsList.addAll(list)
        notifyDataSetChanged()
    }
}