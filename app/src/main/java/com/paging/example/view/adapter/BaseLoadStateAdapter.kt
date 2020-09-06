package com.paging.example.view.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.paging.example.view.item.LoadingItem

class BaseLoadStateAdapter : LoadStateAdapter<LoadingItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = LoadingItem(parent)

    override fun onBindViewHolder(
        holder: LoadingItem,
        loadState: LoadState
    ) = holder.bind(loadState)

}