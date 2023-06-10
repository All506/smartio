package com.example.smartio.domain

import java.io.Serializable
import java.io.StreamCorruptedException

data class User(

    val ID: Int,
    val name: String,
    val email: String,
    val password: String,
    val scores: List<IntelligenseScore>? = null,

    ) : Serializable
