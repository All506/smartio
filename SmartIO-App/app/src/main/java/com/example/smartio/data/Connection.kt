package com.example.smartio.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Connection {

    companion object {

        //        private var baseUrl = "http://192.168.1.93:8000/"
        private var baseUrl = "http://140.84.185.52:8000/"

        fun getRetrofit(url: String? = baseUrl): Retrofit {
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

    }
}