package com.worldline.insa.template.features.movies.data.repository

import com.worldline.insa.template.features.movies.data.local.dao.FavoriteMovieDao
import com.worldline.insa.template.features.movies.data.local.entity.FavoriteMovie
import kotlinx.coroutines.flow.Flow

class FavoriteMovieRepository(private val dao: FavoriteMovieDao) {

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
