package com.example.domain.usecase

import android.os.Build
import com.example.domain.interfaces.MovieRepository
import com.example.domain.model.Movie

class GetMovieDetailUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun  invoke(movieId: Int): Movie {


        return movieRepository.getMovieDetails(movieId)
    }
}
