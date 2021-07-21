package com.example.tvshowsapp.framework

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    var BASE_URL = "https://api.tvmaze.com/"
    private var remoteService: RemoteService

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        remoteService = retrofit.create(RemoteService::class.java)
    }

    fun  getRemoteService(): RemoteService {
        return remoteService
    }
}