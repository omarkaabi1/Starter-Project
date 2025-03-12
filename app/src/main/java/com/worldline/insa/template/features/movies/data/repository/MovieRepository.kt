package com.worldline.insa.template.features.movies.data.repository

import RemoteMovieDataSource
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
            backdrop_path = this.backdrop,
            id = this.id,
            original_language = this.language,
            original_title = this.originaltitle,
            overview = this.overview,
            popularity = this.popularity,
            poster_path = "$IMAGE_URL${this.poster}",
            release_date = this.date,
            title = this.title,
            video = this.video,
            vote_average = this.average,
            vote_count = this.count
        )
    }

    companion object {
        private const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }

}