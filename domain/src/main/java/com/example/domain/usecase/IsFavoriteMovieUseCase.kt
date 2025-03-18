package com.example.domain.usecase

import com.example.domain.interfaces.FavoriteMovieRepository
import kotlinx.coroutines.flow.Flow

class IsFavoriteMovieUseCase(private val repository: FavoriteMovieRepository) {
    operator fun invoke(movieId: Int): Flow<Boolean> {
        return repository.isFavorite(movieId)
    }
}
