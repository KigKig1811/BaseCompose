package com.xt.notes.data.network

import com.xt.notes.data.dto.MovieDto
import com.xt.notes.data.dto.NetfWrapper
import retrofit2.http.GET

interface MovieService {
    @GET("3/trending/movie/day")
    suspend fun trendingMovies(): NetfWrapper<MovieDto>

    @GET("3/movie/popular")
    suspend fun popularMovies(): NetfWrapper<MovieDto>

    @GET("3/movie/now_playing")
    suspend fun nowPlayingMovies(): NetfWrapper<MovieDto>

    @GET("3/movie/upcoming")
    suspend fun upcomingMovies(): NetfWrapper<MovieDto>

    @GET("3/movie/top_rated")
    suspend fun topRatedMovies(): NetfWrapper<MovieDto>

    @GET("3/discover/movie")
    suspend fun discoverMovies(): NetfWrapper<MovieDto>
}
