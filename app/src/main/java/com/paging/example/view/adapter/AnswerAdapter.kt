package com.paging.example.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.paging.example.R
import com.paging.example.model.Answer
import com.paging.example.view.item.AnswerItem

class AnswerAdapter(
    private val context: Context,
) : PagingDataAdapter<Answer, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Answer>() {

            override fun areItemsTheSame(oldItem: Answer, newItem: Answer): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Answer, newItem: Answer): Boolean {
                return oldItem.answer_id == newItem.answer_id
            }

        }

    }


    private var mOnItemClick: ((position: Int, answer: Answer) -> Unit)? = null

    //**********************************************************************************************
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val view = layoutInflater.inflate(R.layout.item_answer, parent, false)

        return AnswerItem(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AnswerItem).bind(getItem(position))

        holder.itemView.setOnClickListener {

            if (mOnItemClick != null && getItem(position) != null) {
                mOnItemClick!!.invoke(position, getItem(position)!!)
            }

        }

    }

    internal fun setOnItemClickListener(
        onItemClickListener: ((position: Int, answer: Answer) -> Unit)
    ) {
        mOnItemClick = onItemClickListener
    }

}