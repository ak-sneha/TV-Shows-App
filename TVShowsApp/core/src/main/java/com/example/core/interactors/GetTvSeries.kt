package com.example.core.interactors

import com.example.core.data.TvSeriesRepository

class GetTvSeries(private val tvSeriesRepository: TvSeriesRepository) {
  suspend operator fun invoke() = tvSeriesRepository.getTvSeries()
}