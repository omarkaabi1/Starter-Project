package com.example.domain.usecase

import com.example.domain.interfaces.FavoriteMovieRepository
import com.example.domain.model.FavoriteMovie
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesUseCase(private val repository: FavoriteMovieRepository) {
    operator fun invoke(): Flow<List<FavoriteMovie>> {
        return repository.getFavorites()
    }
}
