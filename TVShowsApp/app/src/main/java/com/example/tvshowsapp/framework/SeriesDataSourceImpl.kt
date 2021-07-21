package com.example.tvshowsapp.framework

import com.example.core.data.DataSource
import com.example.core.domain.TVSeries

class SeriesDataSourceImpl : DataSource {

    override suspend fun getTvSeriesAsync(): List<TVSeries> =
        RetrofitClient.getRemoteService().getTvSeriesAsync()

}
