package com.example.smartio.ui.questions.adapter

import android.graphics.Color
import android.view.View
import android.widget.SeekBar
import androidx.recyclerview.widget.RecyclerView
import com.example.smartio.databinding.ItemQuestionBinding

class QuestionsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemQuestionBinding.bind(view)

    fun createItem(item: String, position: Int) {

        binding.apply {
            lblQuestion.text = item
            lblQuestionNumber .text = "Question "+ (position + 1).toString() + " of 36"


            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // Cambiar el color del SeekBar dependiendo del valor actual
                    val color = getColorForProgress(progress)
                    seekBar.progressDrawable.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN)
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
            10 -> Color.parseColor("#00FF00") // Verde
            9 -> Color.parseColor("#33FF00") // Verde-amarillo
            8 -> Color.parseColor("#66FF00") // Amarillo
            7 -> Color.parseColor("#99FF00") // Amarillo-naranja
            6 -> Color.parseColor("#CCFF00") // Naranja
            5 -> Color.parseColor("#FF9900") // Naranja-rojo claro
            4 -> Color.parseColor("#FF6600") // Rojo claro
            3 -> Color.parseColor("#FF3300") // Rojo medio
            2 -> Color.parseColor("#FF0000") // Rojo oscuro
            1 -> Color.parseColor("#FF0000") // Rojo
            else -> Color.GRAY
        }
        return color
    }
}