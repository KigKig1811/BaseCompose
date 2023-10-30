package com.xt.notes.data.di

import android.content.Context
import androidx.room.Room
import com.xt.notes.data.source.local.database.NetfChillDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNetfChillDatabase(@ApplicationContext context: Context): NetfChillDatabase =
        Room.databaseBuilder(
            context,
            NetfChillDatabase::class.java,
            "NetfChill.db"
        ).build()

    @Singleton
    @Provides
    fun provideMovieDao(db: NetfChillDatabase) = db.movieDao

    @Singleton
    @Provides
    fun provideTvShowDao(db: NetfChillDatabase) = db.tvShowDao
}
