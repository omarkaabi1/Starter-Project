package com.worldline.insa.template.features.movies.data.api

import com.google.gson.annotations.SerializedName


data class MovieResponseItem(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdrop: String,
    val id: Int,
    @SerializedName("original_language")
    val language: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("release_date")
    val date: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val average: Double,
    @SerializedName("vote_count")
    val count: Int
)

data class MovieResponse(
    val results: List<MovieResponseItem>
)
