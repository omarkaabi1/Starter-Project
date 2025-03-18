package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.FavoriteMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(movie: FavoriteMovie)

    @Delete
    suspend fun removeFavorite(movie: FavoriteMovie)

    @Query("SELECT * FROM favorite_movies")
    fun getFavorites(): Flow<List<FavoriteMovie>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_movies WHERE id = :id)")
    fun isFavorite(id: Int): Flow<Boolean>
}
