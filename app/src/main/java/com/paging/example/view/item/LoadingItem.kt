package com.paging.example.view.item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.paging.example.R
import com.paging.example.databinding.ItemLoadingBinding

class LoadingItem(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.item_loading, parent, false)

) {

    private val binding = ItemLoadingBinding.bind(itemView)

    internal fun bind(loadState: LoadState) {

        if (loadState is LoadState.Loading) {
            binding.textLoading.visibility = View.VISIBLE
        }
        else {
            binding.textLoading.visibility = View.INVISIBLE
        }

    }

}