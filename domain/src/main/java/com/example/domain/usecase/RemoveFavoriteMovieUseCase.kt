package com.example.domain.usecase

import com.example.domain.interfaces.FavoriteMovieRepository

class RemoveFavoriteMovieUseCase(private val repository: FavoriteMovieRepository) {
    suspend operator fun invoke(movie: Int) {
        repository.removeFavorite(movie)
    }
}
