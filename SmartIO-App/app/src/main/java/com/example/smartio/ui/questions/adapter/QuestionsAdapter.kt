package com.example.smartio.ui.questions.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.smartio.R

class QuestionsAdapter(private val items: List<Question>, private val checkList: List<View>) :
    RecyclerView.Adapter<QuestionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return QuestionsViewHolder(layoutInflater.inflate(R.layout.item_question, parent, false))
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val item = items[position]

        holder.createItem(item, position, checkList as List<CheckBox>)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
