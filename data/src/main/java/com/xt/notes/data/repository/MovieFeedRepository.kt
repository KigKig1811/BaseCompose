package com.xt.notes.data.repository

import android.content.Context
import com.xt.notes.data.di.IoDispatcher
import com.xt.notes.data.dto.asMovieResult
import com.xt.notes.data.network.MovieService
import com.xt.notes.domain.model.Movie
import com.xt.notes.domain.repository.BaseFeedRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieFeedRepository @Inject constructor(
    @ApplicationContext context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
    private val movieApi: MovieService,
) : BaseFeedRepository<Movie>(context, ioDispatcher) {

    override suspend fun popularItems(): List<Movie> =
        movieApi.popularMovies().items.asMovieResult()

    override suspend fun latestItems(): List<Movie> =
        movieApi.upcomingMovies().items.asMovieResult()

    override suspend fun topRatedItems(): List<Movie> =
        movieApi.topRatedMovies().items.asMovieResult()

    override suspend fun trendingItems(): List<Movie> =
        movieApi.trendingMovies().items.asMovieResult()

    override suspend fun nowPlayingItems(): List<Movie> =
        movieApi.nowPlayingMovies().items.asMovieResult()

    override suspend fun discoverItems(): List<Movie> =
        movieApi.discoverMovies().items.asMovieResult()

    override fun getNowPlayingResId(): Int = com.xt.common.R.string.text_now_playing

    override fun getLatestResId(): Int = com.xt.common.R.string.text_upcoming

}
