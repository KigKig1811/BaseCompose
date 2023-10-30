package com.xt.notes.common.model

open class NetfItem(
    open val id: Int,
    open val overview: String,
    open val releaseDate: String?,
    open val posterUrl: String?,
    open val backdropUrl: String?,
    open val name: String,
    open val voteAverage: Double,
    open val voteCount: Int,
)
