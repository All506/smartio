package com.example.smartio.domain

import java.io.Serializable

data class Question(
    val question: String,
    var answer: Int,
    var isAnswered: Boolean = false
): Serializable