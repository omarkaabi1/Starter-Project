package com.example.domain.usecase

import com.example.domain.interfaces.FavoriteMovieRepository

class AddFavoriteMovieUseCase(private val repository: FavoriteMovieRepository) {
    suspend operator fun invoke(movie: Int) {
        repository.addFavorite(movie)
    }
}
