package com.worldline.insa.template.features.movies.domain.usecase

import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.domain.model.Movie

class GetPopularMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> {
        val movieResponse = movieRepository.getPopularMovies()
        return movieResponse
    }}
