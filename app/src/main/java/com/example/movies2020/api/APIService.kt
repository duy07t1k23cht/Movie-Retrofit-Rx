package com.example.movies2020.api

import com.example.movies2020.model.Movie
import com.example.movies2020.model.SearchResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
interface APIService {

    @GET(".")
    fun getMovieDetails(@Query("i") movieID: String): Observable<Movie>

    @GET(".")
    fun getMoviesListByQuery(
        @Query("s") query: String,
        @Query("page") page: Int
    ): Observable<SearchResponse>

}