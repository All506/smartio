package com.example.smartio.ui.questions.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.smartio.databinding.ItemQuestionBinding

class QuestionsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemQuestionBinding.bind(view)

    fun createItem(item: String) {

        binding.apply {
            lblQuestion.text = item
        }

    }
}