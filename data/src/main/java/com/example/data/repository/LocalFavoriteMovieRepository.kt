package com.example.data.repository

import com.example.data.local.dao.FavoriteMovieDao
import com.example.domain.interfaces.FavoriteMovieRepository
import com.example.domain.model.FavoriteMovie
import kotlinx.coroutines.flow.Flow

class LocalFavoriteMovieRepository(private val dao: FavoriteMovieDao) : FavoriteMovieRepository {

    override suspend fun addFavorite(movie: FavoriteMovie) {
        dao.addFavorite(movie)
    }

    override suspend fun removeFavorite(movie: FavoriteMovie) {
        dao.removeFavorite(movie)
    }

    override fun getFavorites(): Flow<List<FavoriteMovie>> {
        return dao.getFavorites()
    }

    override fun isFavorite(id: Int): Flow<Boolean> {
        return dao.isFavorite(id)
    }
}
