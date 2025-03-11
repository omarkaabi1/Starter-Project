package com.worldline.insa.template.features.movies.data.repository

import RemoteMovieDataSource
import com.worldline.insa.template.features.movies.domain.model.Movie

class MovieRepository (private val remoteMovieDataSource: RemoteMovieDataSource){
    suspend fun getPopularMovies(): List<Movie> {
        return remoteMovieDataSource.getPopularMovies().results.map { movieResponseItem ->

            Movie(
                adult = movieResponseItem.adult,
                backdrop_path = movieResponseItem.backdrop,
                genre_ids = movieResponseItem.genre,
                id = movieResponseItem.id,
                original_language = movieResponseItem.language,
                original_title = movieResponseItem.originaltitle,
                overview = movieResponseItem.overview,
                popularity = movieResponseItem.popularity,
                poster_path = "https://image.tmdb.org/t/p/w500${movieResponseItem.poster}",
                release_date = movieResponseItem.date,
                title = movieResponseItem.title,
                video = movieResponseItem.video,
                vote_average = movieResponseItem.average,
                vote_count = movieResponseItem.count,

            )
        }

    }
}

