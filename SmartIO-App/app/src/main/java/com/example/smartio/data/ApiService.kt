package com.example.smartio.data;

import com.example.smartio.domain.IntelligenceScore
import com.example.smartio.domain.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("user")
    suspend fun createUser(@Body user: User): Response<Void>

    @POST("user/login")
    suspend fun loginUser(@Body user: User): Response<User>

    @POST("score/{userId}")
    suspend fun createScores(@Path("userId") id:Int, @Body scores: List<IntelligenceScore>): Response<List<String>>

}