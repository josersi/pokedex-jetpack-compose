package com.github.josersi.pokedex.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


internal val retrofit = Retrofit.Builder()
    .baseUrl("https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/")
    .client(makeOkHttpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private fun makeOkHttpClient()
    = OkHttpClient.Builder().addInterceptor(makeLoggingInterceptor()).build()

private fun makeLoggingInterceptor()
    = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
