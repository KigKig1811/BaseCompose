package com.xt.notes.data.repository

import android.content.Context
import com.xt.notes.data.di.IoDispatcher
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
    // private val movieApi: MovieService,
) : BaseFeedRepository<Movie>(context, ioDispatcher) {

    override suspend fun popularItems(): List<Movie> = emptyList()

    override suspend fun latestItems(): List<Movie> = emptyList()

    override suspend fun topRatedItems(): List<Movie> = emptyList()

    override suspend fun trendingItems(): List<Movie> = emptyList()

    override suspend fun nowPlayingItems(): List<Movie> = emptyList()

    override suspend fun discoverItems(): List<Movie> = emptyList()

    override fun getNowPlayingResId(): Int = 0

    override fun getLatestResId(): Int = 0

}
