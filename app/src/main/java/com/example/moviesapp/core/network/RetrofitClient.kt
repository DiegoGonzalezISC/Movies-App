package com.example.moviesapp.core.network

import com.example.moviesapp.core.Constants.BASE_URL
import com.example.moviesapp.core.network.AuthConstants.API_TOKEN
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(API_TOKEN))
        .build()

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}