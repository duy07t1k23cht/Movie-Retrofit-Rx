package com.example.movies2020.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


/**
 * Created by Duy M. Nguyen on 4/30/2020.
 */
class SearchResponse {
    @SerializedName("Search")
    @Expose
    var movies: MutableList<Movie>? = null

    @SerializedName("totalResults")
    @Expose
    var totalResults: String? = null

    @SerializedName("Response")
    @Expose
    var response: String? = null

    @SerializedName("Error")
    var error: String? = null
}
