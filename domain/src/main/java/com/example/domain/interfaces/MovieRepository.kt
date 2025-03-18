package com.example.domain.interfaces

import com.example.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovieDetails(movieId: Int): Movie
}
