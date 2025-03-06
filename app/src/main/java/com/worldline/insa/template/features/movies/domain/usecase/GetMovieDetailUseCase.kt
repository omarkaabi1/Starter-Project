package com.worldline.insa.template.features.movies.domain.usecase

import com.worldline.insa.template.features.movies.data.MovieRepository
import com.worldline.insa.template.features.movies.data.model.Movie


class GetMovieDetailUseCase(private val repository: MovieRepository) {
    fun execute(title: String): Movie? = repository.getMovieDetail(title)
}
