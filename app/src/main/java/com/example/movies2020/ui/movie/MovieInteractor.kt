package com.example.movies2020.ui.movie

import com.example.movies2020.R
import com.example.movies2020.api.API
import com.example.movies2020.api.APIService
import com.example.movies2020.model.Movie
import com.example.movies2020.ui.main.MainContract
import com.example.movies2020.utils.getStringByRes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Duy M. Nguyen on 4/30/2020.
 */
class MovieInteractor : MovieContract.Interactor {

    override fun getMovieDetail(
        movieID: String,
        successCallback: (Movie) -> Unit,
        failedCallback: (String) -> Unit
    ) {
        API.apiService.getMovieDetails(movieID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                successCallback(it)
            }, {
                failedCallback(it.message ?: getStringByRes(R.string.something_went_wrong))
            })
            .isDisposed
    }
}