package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movies")
data class FavoriteMovie(
    @PrimaryKey val id: Int,
    val title: String,
    val posterPath: String
)

fun Movie.toFavoriteMovie(): FavoriteMovie {
    return FavoriteMovie(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath
    )
}

fun FavoriteMovie.toMovie(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath,
        adult = false,
        backdropPath = "",
        originalLanguage = "",
        originalTitle = "",
        overview = "",
        popularity = 0.0,
        releaseDate = "",
        video = false,
        voteAverage = 0.0,
        voteCount = 0

    )
}