package com.worldline.insa.template.features.movies.domain.usecase

import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.data.model.Movie



class GetMovieListUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(apiKey: String): List<Movie> {
        val movieResponse = movieRepository.getPopularMovies(apiKey)
        return movieResponse.results
    }}
