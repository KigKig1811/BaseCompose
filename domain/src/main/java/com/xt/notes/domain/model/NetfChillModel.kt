package com.xt.notes.domain.model

import com.xt.notes.common.model.NetfItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    override val id: Int,
    override val overview: String,
    override val releaseDate: String?,
    override val posterUrl: String?,
    override val backdropUrl: String?,
    override val name: String,
    override val voteAverage: Double,
    override val voteCount: Int
): NetfItem
