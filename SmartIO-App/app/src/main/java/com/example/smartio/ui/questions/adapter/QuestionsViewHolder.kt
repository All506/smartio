package com.example.smartio.ui.questions.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.CheckBox
import android.widget.SeekBar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.smartio.R
import com.example.smartio.databinding.ItemQuestionBinding
import com.example.smartio.ui.questions.QuestionsFragment

class QuestionsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemQuestionBinding.bind(view)

    fun createItem(item: Question, position: Int, checkBox: List<CheckBox>) {

        binding.apply {
            lblQuestion.text = item.question
            lblQuestionNumber.text = "Pregunta " + (position + 1).toString() + " de 36"
            seekBar.progress = item.answer
            val color = getColorForProgress(item.answer)
            seekBar.progressDrawable.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN)

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // Cambiar el color del SeekBar dependiendo del valor actual
                    val color = getColorForProgress(progress)
                    seekBar.progressDrawable.setColorFilter(
                        color,
                        android.graphics.PorterDuff.Mode.SRC_IN
                    )
                    item.answer = progress
                    checkBox[position].buttonTintList = ColorStateList.valueOf(color)

                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // No se necesita implementar en este caso
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // No se necesita implementar en este caso
                }
            })
        }

    }

    private fun getColorForProgress(progress: Int): Int {
        val color = when (progress) {
            10 -> Color.parseColor("#B1EDC6")
            9 -> Color.parseColor("#D1F4BD")
            8 -> Color.parseColor("#EAFBC3")
            7 -> Color.parseColor("#FFF7AF")
            6 -> Color.parseColor("#FFE7A7")
            5 -> Color.parseColor("#FFDAA1")
            4 -> Color.parseColor("#FFC495")
            3 -> Color.parseColor("#FFB18A")
            2 -> Color.parseColor("#FF9B80")
            1 -> Color.parseColor("#FF8775")
            else -> Color.parseColor("#FF726A")
        }
        return color
    }
}