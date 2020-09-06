package com.paging.example.view.item

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.paging.example.model.Answer
import kotlinx.android.synthetic.main.item_answer.view.*

class AnswerItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(answer: Answer?) {
        if (answer == null) {
            return
        }

        itemView.textOwnerName.text = answer.owner?.display_name
        itemView.textAnswerScore.text = answer.score.toString()
    }

}