package com.example.data.repository

import com.example.data.local.dao.FavoriteMovieDao
import com.example.domain.interfaces.FavoriteMovieRepository
import com.example.data.local.entity.toFavoriteMovie
import com.example.data.local.entity.toMovie
import com.example.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalFavoriteMovieRepository(private val dao: FavoriteMovieDao) : FavoriteMovieRepository {

    override suspend fun addFavorite(movie: Movie) {
        dao.addFavorite(movie.toFavoriteMovie())
    }

    override suspend fun removeFavorite(movie: Movie) {
        dao.removeFavorite(movie.toFavoriteMovie())
    }

    override fun getFavorites(): Flow<List<Movie>> {
        return dao.getFavorites().map { list -> list.map { it.toMovie() } }
    }

    override fun isFavorite(id: Int): Flow<Boolean> {
        return dao.isFavorite(id)
    }
}
