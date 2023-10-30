package com.xt.notes.data.source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TVShows")
data class TVShowEntity(
    @PrimaryKey val id: Int,
    val overview: String,
    val releaseDate: String?,
    val posterUrl: String?,
    val backdropUrl: String?,
    val name: String,
    val voteAverage: Double,
    val voteCount: Int
)
