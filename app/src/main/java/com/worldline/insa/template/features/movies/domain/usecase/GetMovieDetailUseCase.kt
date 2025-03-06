package com.worldline.insa.template.features.movies.domain.usecase

import com.worldline.insa.template.features.movies.data.MovieRepository
import com.worldline.insa.template.features.movies.data.model.Movie
import kotlinx.coroutines.delay


class GetMovieDetailUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(title: String): Movie? {
        delay(1000)
        return repository.getMovieDetail(title)
    }
}
