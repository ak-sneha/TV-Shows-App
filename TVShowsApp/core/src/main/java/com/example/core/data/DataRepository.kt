package com.example.core.data

import com.example.core.domain.TVSeries

interface DataRepository {

    suspend fun getTvSeries() : List<TVSeries>
}