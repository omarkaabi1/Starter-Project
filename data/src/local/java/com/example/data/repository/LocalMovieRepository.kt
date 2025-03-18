package com.example.data.repository

import com.example.domain.interfaces.MovieRepository
import com.example.domain.model.Movie

class LocalMovieRepository : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return listOf(movieExample)
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return movieExample
    }

    private companion object {
        private val movieExample = Movie(
            adult = false,
            backdropPath = "backdropPath",
            id = 0,
            originalLanguage = "originalLanguage",
            originalTitle = "originalTitle",
            overview = "overview",
            popularity = 10.0,
            posterPath = "https://m.media-amazon.com/images/I/714b1KQmskL._AC_UF1000,1000_QL80_.jpg",
            releaseDate = "releaseDate",
            title = "title",
            video = true,
            voteAverage = 10.0,
            voteCount = 10,
        )
    }

}