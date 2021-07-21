package com.example.core.data

import com.example.core.domain.TVSeries

interface DataSource {
    suspend fun getTvSeriesAsync(): List<TVSeries>
}
