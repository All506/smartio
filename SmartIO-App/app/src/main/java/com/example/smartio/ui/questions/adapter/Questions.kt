package com.example.smartio.ui.questions.adapter

import android.content.Context
import com.example.smartio.R

class Questions(private val context: Context) {
    fun getQuestions(): List<String> {
        return listOf(
            context.getString(R.string.pregunta1),
            context.getString(R.string.pregunta2),
            context.getString(R.string.pregunta3),
            context.getString(R.string.pregunta4),
            context.getString(R.string.pregunta5),
            context.getString(R.string.pregunta6),
            context.getString(R.string.pregunta7),
            context.getString(R.string.pregunta8),
            context.getString(R.string.pregunta9),
            context.getString(R.string.pregunta10),
            context.getString(R.string.pregunta11),
            context.getString(R.string.pregunta12),
            context.getString(R.string.pregunta13),
            context.getString(R.string.pregunta14),
            context.getString(R.string.pregunta15),
            context.getString(R.string.pregunta16),
            context.getString(R.string.pregunta17),
            context.getString(R.string.pregunta18),
            context.getString(R.string.pregunta19),
            context.getString(R.string.pregunta20),
            context.getString(R.string.pregunta21),
            context.getString(R.string.pregunta22),
            context.getString(R.string.pregunta23),
            context.getString(R.string.pregunta24),
            context.getString(R.string.pregunta25),
            context.getString(R.string.pregunta26),
            context.getString(R.string.pregunta27),
            context.getString(R.string.pregunta28),
            context.getString(R.string.pregunta29),
            context.getString(R.string.pregunta30),
            context.getString(R.string.pregunta31),
            context.getString(R.string.pregunta32),
            context.getString(R.string.pregunta33),
            context.getString(R.string.pregunta34),
            context.getString(R.string.pregunta35),
            context.getString(R.string.pregunta36)
        )
    }
}