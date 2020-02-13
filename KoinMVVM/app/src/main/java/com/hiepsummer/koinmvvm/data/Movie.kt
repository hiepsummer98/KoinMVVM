package com.hiepsummer.koinmvvm.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieCollection(@SerialName(value = "page") val page: Int, @SerialName(value = "result") val movies: ArrayList<Movie>
) {
    @Serializable
    data class Movie(
        @SerialName(value = "id") val id: Long,
        @SerialName(value = "poster_path") val posterURL: String,
        @SerialName(value = "original_title") val name: String,
        @SerialName(value = "vote_average") val rating: Float,
        @SerialName(value = "overview") val description: String,
        @SerialName(value = "release_date") val releaseDate: String
    ) {
        var isFavorite: Boolean = false
    }
}