package com.example.core.data

class TvSeriesRepository(private val dataSource: DataSource) : DataRepository {

    override suspend fun getTvSeries() = dataSource.getTvSeriesAsync()
}