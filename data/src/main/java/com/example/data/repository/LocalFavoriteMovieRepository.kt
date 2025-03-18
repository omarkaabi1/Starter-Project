package com.example.data.repository

import com.example.data.local.dao.FavoriteMovieDao
import com.example.data.local.entity.FavoriteMovie
import kotlinx.coroutines.flow.Flow

class LocalFavoriteMovieRepository(private val dao: FavoriteMovieDao) {

    suspend fun addFavorite(movie: FavoriteMovie) {
        dao.addFavorite(movie)
    }

    suspend fun removeFavorite(movie: FavoriteMovie) {
        dao.removeFavorite(movie)
    }

    fun getFavorites(): Flow<List<FavoriteMovie>> {
        return dao.getFavorites()
    }

    fun isFavorite(id: Int): Flow<Boolean> {
        return dao.isFavorite(id)
    }
}
