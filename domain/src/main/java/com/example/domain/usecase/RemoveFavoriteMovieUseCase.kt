package com.example.domain.usecase

import com.example.domain.interfaces.FavoriteMovieRepository
import com.example.domain.model.Movie

class RemoveFavoriteMovieUseCase(private val repository: FavoriteMovieRepository) {
    suspend operator fun invoke(movie: Movie) {
        repository.removeFavorite(movie)
    }
}
