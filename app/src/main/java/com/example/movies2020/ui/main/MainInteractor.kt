package com.example.movies2020.ui.main

import android.util.Log
import com.example.movies2020.R
import com.example.movies2020.api.API
import com.example.movies2020.model.Movie
import com.example.movies2020.utils.APIConstant
import com.example.movies2020.utils.getStringByRes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
class MainInteractor : MainContract.Interactor {

    override fun searchMovie(
        query: String,
        page: Int,
        successCallback: (MutableList<Movie>) -> Unit,
        failedCallback: (String) -> Unit
    ) {
        API.apiService.getMoviesListByQuery(query, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val response = it.response.toString().toBoolean()
                if (response) {
                    val listMovies = it.movies
                    if (listMovies.isNullOrEmpty()) {
                        failedCallback(getStringByRes(R.string.no_movie_found))
                    } else {
                        successCallback(listMovies)
                    }
                } else {
                    failedCallback(it.error ?: getStringByRes(R.string.something_went_wrong))
                }
            }, {
                failedCallback(it.message ?: getStringByRes(R.string.something_went_wrong))
            })
            .isDisposed
    }

    override fun getMovieDetail(
        movieID: String,
        successCallback: (Movie) -> Unit,
        failedCallback: (String) -> Unit
    ) {
        API.apiService.getMovieDetails(movieID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it == null) {
                    failedCallback(getStringByRes(R.string.movie_not_found))
                } else {
                    successCallback(it)
                }
            }, {
                failedCallback(it.message ?: getStringByRes(R.string.something_went_wrong))
            })
            .isDisposed
    }
}