package com.example.smartio.data;

import com.example.smartio.domain.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("user")
    suspend fun createUser(@Body user: User): Response<Void>

    @POST("user/login")
    suspend fun loginUser(@Body user: User): Response<User>

    @POST("user/scores")
    suspend fun createScore(@Body user: User): Response<Void>

    @GET("user/matches")
    suspend fun getMatches(@Body user: User): Response<List<User>>

}