package com.example.smartio.ui.questions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartio.R
import com.example.smartio.databinding.ItemQuestionBinding

class QuestionsAdapter(private val items: List<String>) :
    RecyclerView.Adapter<QuestionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return QuestionsViewHolder(layoutInflater.inflate(R.layout.item_question, parent, false))
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val item = items[position]

        holder.createItem(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
