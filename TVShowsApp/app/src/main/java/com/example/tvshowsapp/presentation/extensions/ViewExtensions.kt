package com.example.tvshowsapp.presentation.extensions

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.init(
    adapter: RecyclerView.Adapter<*>,
    hasFixedSize: Boolean = false
): RecyclerView {
    setHasFixedSize(hasFixedSize)
    setAdapter(adapter)
    return this
}