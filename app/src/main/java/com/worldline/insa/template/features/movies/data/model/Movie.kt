package com.worldline.insa.template.features.movies.data.model


data class Movie(
    val title: String,
    val poster: Int,
    val description: String,
    val actors: List<String>,
    val isError : Boolean = false
)
