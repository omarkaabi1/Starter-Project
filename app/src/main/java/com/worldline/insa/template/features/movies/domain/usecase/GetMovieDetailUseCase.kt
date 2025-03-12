package com.worldline.insa.template.features.movies.domain.usecase

import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.domain.model.Movie

class GetMovieDetailUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(movieId: Int): Movie {
        return movieRepository.getMovieDetails(movieId)
    }
}
