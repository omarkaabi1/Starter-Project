package com.example.domain.interfaces

import com.example.domain.model.FavoriteMovie
import kotlinx.coroutines.flow.Flow

interface FavoriteMovieRepository {
    suspend fun addFavorite(movie: FavoriteMovie)
    suspend fun removeFavorite(movie: FavoriteMovie)
    fun getFavorites(): Flow<List<FavoriteMovie>>
    fun isFavorite(id: Int): Flow<Boolean>
}
