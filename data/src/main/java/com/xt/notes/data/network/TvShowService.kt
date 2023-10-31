package com.xt.notes.data.network

import com.xt.notes.data.dto.NetfWrapper
import com.xt.notes.data.dto.TvShowDto
import retrofit2.http.GET

interface TvShowService {
    @GET("3/trending/tv/day")
    suspend fun trendingTVSeries(): NetfWrapper<TvShowDto>

    @GET("3/tv/popular")
    suspend fun popularTVSeries(): NetfWrapper<TvShowDto>

    @GET("3/tv/airing_today")
    suspend fun airingTodayTVSeries(): NetfWrapper<TvShowDto>

    @GET("3/tv/on_the_air")
    suspend fun onTheAirTVSeries(): NetfWrapper<TvShowDto>

    @GET("3/tv/top_rated")
    suspend fun topRatedTVSeries(): NetfWrapper<TvShowDto>

    @GET("3/discover/tv")
    suspend fun discoverTVSeries(): NetfWrapper<TvShowDto>
}
