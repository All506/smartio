package com.example.smartio.domain

import java.io.Serializable

data class User(

    val ID: Int,
    val name: String,
    val email: String,
    val password: String,
    val scores: List<IntelligenceScore>? = null,

    ){
    companion object {
        var actualUser: User? = null
    }

}

