package com.xt.notes.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xt.notes.data.source.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(movieEntity: MovieEntity)

    @Query("DELETE FROM movies WHERE id = :id")
    suspend fun deleteBookmark(id: Int)

    @Query("SELECT EXISTS(SELECT * FROM Movies WHERE id = :id)")
    suspend fun isBookmarked(id: Int): Boolean

    @Query("SELECT * FROM movies ORDER BY releaseDate DESC")
    suspend fun getBookmarks(): List<MovieEntity>
}
