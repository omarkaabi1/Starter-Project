package com.worldline.insa.template.features.movies.data

import com.worldline.insa.template.R
import com.worldline.insa.template.features.movies.data.model.Movie

class MovieRepository {
    fun getMovieList(): List<Movie> = movieList

    fun getMovieDetail(title: String): Movie? = movieList.find { it.title == title && !it.isError }
}

private val movieList = listOf(
    Movie("Inception", R.drawable.inception, "A mind-bending thriller", listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt")),
    Movie("Interstellar", R.drawable.inception, "A journey beyond the stars", listOf("Matthew McConaughey", "Anne Hathaway")),
    Movie("The Dark Knight", R.drawable.inception, "Gotham's hero rises", listOf("Christian Bale", "Heath Ledger")),
    Movie("Pulp Fiction", R.drawable.inception, "A mix of crime and dark humor", listOf("John Travolta", "Samuel L. Jackson")),
    Movie("Fight Club", R.drawable.inception, "An underground fight club", listOf("Brad Pitt", "Edward Norton")),
    Movie("Inception", R.drawable.inception, "A mind-bending thriller", listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt")),
    Movie("Interstellar", R.drawable.inception, "A journey beyond the stars", listOf("Matthew McConaughey", "Anne Hathaway")),
    Movie("The Dark Knight", R.drawable.inception, "Gotham's hero rises", listOf("Christian Bale", "Heath Ledger")),
    Movie("Pulp Fiction", R.drawable.inception, "A mix of crime and dark humor", listOf("John Travolta", "Samuel L. Jackson")),
    Movie("Fight Club2", R.drawable.inception, "An underground fight club", listOf("Brad Pitt", "Edward Norton") , true)

)
