package com.worldline.insa.template.features.movies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.worldline.insa.template.features.movies.data.local.dao.FavoriteMovieDao
import com.worldline.insa.template.features.movies.data.local.entity.FavoriteMovie

@Database(entities = [FavoriteMovie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao(): FavoriteMovieDao
}


