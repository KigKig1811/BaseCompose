package com.xt.notes.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xt.notes.data.source.entity.MovieEntity
import com.xt.notes.data.source.entity.TVShowEntity
import com.xt.notes.data.source.local.dao.MovieDao
import com.xt.notes.data.source.local.dao.TvShowDao

@Database(entities = [MovieEntity::class, TVShowEntity::class], version = 1, exportSchema = false)
abstract class NetfChillDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
    abstract val tvShowDao: TvShowDao
}
