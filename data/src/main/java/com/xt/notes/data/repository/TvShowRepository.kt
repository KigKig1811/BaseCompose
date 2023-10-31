package com.xt.notes.data.repository

import android.content.Context
import com.xt.notes.data.di.IoDispatcher
import com.xt.notes.data.dto.asTVShowDomainModel
import com.xt.notes.data.network.TvShowService
import com.xt.notes.domain.model.TvShow
import com.xt.notes.domain.repository.BaseFeedRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepository @Inject constructor(
    @ApplicationContext context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
    private val tvShowApi: TvShowService,
) : BaseFeedRepository<TvShow>(context, ioDispatcher) {
    override suspend fun popularItems(): List<TvShow> =
        tvShowApi.popularTVSeries().items.asTVShowDomainModel()

    override suspend fun nowPlayingItems(): List<TvShow> =
        tvShowApi.airingTodayTVSeries().items.asTVShowDomainModel()

    override suspend fun latestItems(): List<TvShow> =
        tvShowApi.onTheAirTVSeries().items.asTVShowDomainModel()

    override suspend fun topRatedItems(): List<TvShow> =
        tvShowApi.topRatedTVSeries().items.asTVShowDomainModel()

    override suspend fun trendingItems(): List<TvShow> =
        tvShowApi.trendingTVSeries().items.asTVShowDomainModel()

    override suspend fun discoverItems(): List<TvShow> =
        tvShowApi.discoverTVSeries().items.asTVShowDomainModel()

    override fun getNowPlayingResId(): Int = com.xt.common.R.string.text_airing_today

    override fun getLatestResId(): Int = com.xt.common.R.string.text_on_the_air
}
