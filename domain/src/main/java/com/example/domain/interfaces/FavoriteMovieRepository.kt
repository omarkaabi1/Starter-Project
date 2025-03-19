package com.example.domain.interfaces

import com.example.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface FavoriteMovieRepository {
    suspend fun addFavorite(movie: Movie)
    suspend fun removeFavorite(movie: Movie)
    fun getFavorites(): Flow<List<Movie>>
    fun isFavorite(id: Int): Flow<Boolean>
}
