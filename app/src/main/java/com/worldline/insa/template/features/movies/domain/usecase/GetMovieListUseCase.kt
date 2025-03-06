package com.worldline.insa.template.features.movies.domain.usecase

import com.worldline.insa.template.features.movies.data.MovieRepository
import com.worldline.insa.template.features.movies.data.model.Movie



class GetMovieListUseCase(private val repository: MovieRepository) {
    fun execute(): List<Movie> = repository.getMovieList()
}
