package com.xt.notes.data.di

import com.xt.notes.data.repository.MovieFeedRepository
import com.xt.notes.data.repository.TvShowRepository
import com.xt.notes.domain.model.Movie
import com.xt.notes.domain.model.TvShow
import com.xt.notes.domain.repository.BaseFeedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindMovieFeedRepository(movieFeedRepository: MovieFeedRepository): BaseFeedRepository<Movie>

    @Singleton
    @Binds
    internal abstract fun bindTvShowFeedRepository(tvShowRepository: TvShowRepository): BaseFeedRepository<TvShow>
}
