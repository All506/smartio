package com.example.smartio.domain

data class User(

    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    var scores: List<IntelligenceScore> = null!!

    ){
    companion object {
        var actualUser: User? = null
    }

}

