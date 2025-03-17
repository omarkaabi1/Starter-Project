package com.worldline.insa.template.features.movies.data.repository

import com.worldline.insa.template.features.movies.data.local.dao.FavoriteMovieDao
import com.worldline.insa.template.features.movies.data.local.entity.FavoriteMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class FavoriteMovieRepository(private val dao: FavoriteMovieDao) {

    suspend fun addFavorite(movie: FavoriteMovie) {
        withContext(Dispatchers.IO) {
        dao.addFavorite(movie)
        }
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
