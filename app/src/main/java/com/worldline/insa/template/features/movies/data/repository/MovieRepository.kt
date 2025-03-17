package com.worldline.insa.template.features.movies.data.repository

import com.worldline.insa.template.features.movies.data.retrofit.RemoteMovieDataSource
import com.worldline.insa.template.features.movies.data.api.MovieResponseItem
import com.worldline.insa.template.features.movies.domain.model.Movie

class MovieRepository (private val remoteMovieDataSource: RemoteMovieDataSource){
    suspend fun getPopularMovies(): List<Movie> {
        return remoteMovieDataSource.getPopularMovies().results.map { it.toMovie() }
    }
    suspend fun getMovieDetails(movieId: Int): Movie {
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