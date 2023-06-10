package com.example.smartio.domain

import android.content.Context
import com.example.smartio.R

class QuestionFactory(private val context: Context) {

    fun getQuestions(): List<Question> {
        return listOf(
            Question(context.getString(R.string.pregunta1), 0),
            Question(context.getString(R.string.pregunta2), 0),
            Question(context.getString(R.string.pregunta3), 0),
            Question(context.getString(R.string.pregunta4), 0),
            Question(context.getString(R.string.pregunta5), 0),
//            Question(context.getString(R.string.pregunta6), 0),
//            Question(context.getString(R.string.pregunta7), 0),
//            Question(context.getString(R.string.pregunta8), 0),
//            Question(context.getString(R.string.pregunta9), 0),
//            Question(context.getString(R.string.pregunta10), 0),
//            Question(context.getString(R.string.pregunta11), 0),
//            Question(context.getString(R.string.pregunta12), 0),
//            Question(context.getString(R.string.pregunta13), 0),
//            Question(context.getString(R.string.pregunta14), 0),
//            Question(context.getString(R.string.pregunta15), 0),
//            Question(context.getString(R.string.pregunta16), 0),
//            Question(context.getString(R.string.pregunta17), 0),
//            Question(context.getString(R.string.pregunta18), 0),
//            Question(context.getString(R.string.pregunta19), 0),
//            Question(context.getString(R.string.pregunta20), 0),
//            Question(context.getString(R.string.pregunta21), 0),
//            Question(context.getString(R.string.pregunta22), 0),
//            Question(context.getString(R.string.pregunta23), 0),
//            Question(context.getString(R.string.pregunta24), 0),
//            Question(context.getString(R.string.pregunta25), 0),
//            Question(context.getString(R.string.pregunta26), 0),
//            Question(context.getString(R.string.pregunta27), 0),
//            Question(context.getString(R.string.pregunta28), 0),
//            Question(context.getString(R.string.pregunta29), 0),
//            Question(context.getString(R.string.pregunta30), 0),
//            Question(context.getString(R.string.pregunta31), 0),
//            Question(context.getString(R.string.pregunta32), 0),
//            Question(context.getString(R.string.pregunta33), 0),
//            Question(context.getString(R.string.pregunta34), 0),
//            Question(context.getString(R.string.pregunta35), 0),
//            Question(context.getString(R.string.pregunta36), 0)
        )
    }

    fun allQuestionsAnswered(questions: List<Question>): Boolean {
        for (question in questions) {
            if (!question.isAnswered) {
                return false
            }
        }
        return true
    }

}