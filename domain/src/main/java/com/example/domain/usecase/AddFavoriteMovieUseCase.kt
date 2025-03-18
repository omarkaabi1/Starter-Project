package com.example.domain.usecase

import com.example.domain.interfaces.FavoriteMovieRepository
import com.example.domain.model.FavoriteMovie

class AddFavoriteMovieUseCase(private val repository: FavoriteMovieRepository) {
    suspend operator fun invoke(movie: FavoriteMovie) {
        repository.addFavorite(movie)
    }
}
