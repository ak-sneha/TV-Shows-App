package com.example.tvshowsapp.framework

import android.app.Application
import com.example.core.data.TvSeriesRepository
import com.example.core.interactors.GetTvSeries

class TVShowsApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val repository = TvSeriesRepository(SeriesDataSourceImpl())

        TvShowsViewModelFactory.inject(
            Interactors( GetTvSeries(repository))
        )
    }
}