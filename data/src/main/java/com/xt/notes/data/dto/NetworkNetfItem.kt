package com.xt.notes.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.xt.notes.common.utils.Constants.BACKDROP_PATH
import com.xt.notes.common.utils.Constants.BASE_WIDTH_342_PATH
import com.xt.notes.common.utils.Constants.BASE_WIDTH_780_PATH
import com.xt.notes.common.utils.Constants.FIRST_AIR_DATE
import com.xt.notes.common.utils.Constants.ID
import com.xt.notes.common.utils.Constants.NAME
import com.xt.notes.common.utils.Constants.OVERVIEW
import com.xt.notes.common.utils.Constants.POSTER_PATH
import com.xt.notes.common.utils.Constants.RELEASE_DATE
import com.xt.notes.common.utils.Constants.TITLE
import com.xt.notes.common.utils.Constants.VOTE_AVERAGE
import com.xt.notes.common.utils.Constants.VOTE_COUNT
import com.xt.notes.domain.model.Movie
import com.xt.notes.domain.model.TvShow

interface NetworkNetfItem {
    val id: Int
    val overview: String
    val releaseDate: String?
    val posterPath: String?
    val backdropPath: String?
    val name: String
    val voteAverage: Double
    val voteCount: Int
}

@JsonClass(generateAdapter = true)
data class MovieDto(
    @Json(name = ID)
    override val id: Int,
    @Json(name = OVERVIEW)
    override val overview: String,
    @Json(name = RELEASE_DATE)
    override val releaseDate: String?,
    @Json(name = POSTER_PATH)
    override val posterPath: String?,
    @Json(name = BACKDROP_PATH)
    override val backdropPath: String?,
    @Json(name = TITLE)
    override val name: String,
    @Json(name = VOTE_AVERAGE)
    override val voteAverage: Double,
    @Json(name = VOTE_COUNT)
    override val voteCount: Int
) : NetworkNetfItem

@JsonClass(generateAdapter = true)
data class TvShowDto(
    @Json(name = ID)
    override val id: Int,
    @Json(name = OVERVIEW)
    override val overview: String,
    @Json(name = FIRST_AIR_DATE)
    override val releaseDate: String?,
    @Json(name = POSTER_PATH)
    override val posterPath: String?,
    @Json(name = BACKDROP_PATH)
    override val backdropPath: String?,
    @Json(name = NAME)
    override val name: String,
    @Json(name = VOTE_AVERAGE)
    override val voteAverage: Double,
    @Json(name = VOTE_COUNT)
    override val voteCount: Int
) : NetworkNetfItem

fun List<MovieDto>.asMovieResult(): List<Movie> =
    map {
        Movie(
            id = it.id,
            overview = it.overview,
            releaseDate = it.releaseDate,
            posterUrl = it.posterPath?.let { posterPath ->
                String.format(
                    BASE_WIDTH_342_PATH,
                    posterPath
                )
            },
            backdropUrl = it.backdropPath?.let { backdropPath ->
                String.format(
                    BASE_WIDTH_780_PATH,
                    backdropPath
                )
            },
            name = it.name,
            voteAverage = it.voteAverage,
            voteCount = it.voteCount
        )
    }

fun List<TvShowDto>.asTvShowResult(): List<TvShow> =
    map {
        TvShow(
            it.id,
            it.overview,
            it.releaseDate,
            it.posterPath?.let { posterPath ->
                String.format(
                    BASE_WIDTH_342_PATH,
                    posterPath
                )
            },
            it.backdropPath?.let { backdropPath ->
                String.format(
                    BASE_WIDTH_780_PATH,
                    backdropPath
                )
            },
            it.name,
            it.voteAverage,
            it.voteCount
        )
    }
