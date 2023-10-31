package com.xt.notes.data.di

import com.xt.data.BuildConfig
import com.xt.notes.data.network.MovieService
import com.xt.notes.data.network.TvShowService
import com.xt.notes.data.utils.createNetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkClient(): Retrofit = createNetworkClient(BuildConfig.TMDB_BASE_URL)

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    @Singleton
    @Provides
    fun provideTvShowService(retrofit: Retrofit): TvShowService =
        retrofit.create(TvShowService::class.java)
}
