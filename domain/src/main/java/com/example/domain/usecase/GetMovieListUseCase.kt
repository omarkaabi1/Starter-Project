package com.example.domain.usecase

import com.example.domain.interfaces.MovieRepository
import com.example.domain.model.Movie

class GetPopularMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> {
        return movieRepository.getPopularMovies()
    }
}
