package com.example.data.repository

import com.example.data.api.MovieResponseItem
import com.example.data.retrofit.RemoteMovieDataSource
import com.example.domain.interfaces.MovieRepository
import com.example.domain.model.Movie

class RemoteMovieRepository(private val remoteMovieDataSource: RemoteMovieDataSource) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return remoteMovieDataSource.getPopularMovies().results.map { it.toMovie() }
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return remoteMovieDataSource.getMovieDetails(movieId).toMovie()
    }

    private fun MovieResponseItem.toMovie(): Movie {
        return Movie(
            adult = this.adult,
            backdropPath = this.backdrop,
            id = this.id,
            originalLanguage = this.language,
            originalTitle = this.originalTitle,
            overview = this.overview,
            popularity = this.popularity,
            posterPath = "$IMAGE_URL${this.poster}",
            releaseDate = this.date,
            title = this.title,
            video = this.video,
            voteAverage = this.average,
            voteCount = this.count
        )
    }

    companion object {
        private const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }

}