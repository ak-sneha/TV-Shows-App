package com.example.tvshowsapp.framework

import com.example.core.domain.TVSeries
import retrofit2.http.GET

interface RemoteService {

    @GET("shows")
    suspend fun getTvSeriesAsync(): List<TVSeries>
}
