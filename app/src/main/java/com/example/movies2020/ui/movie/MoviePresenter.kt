package com.example.movies2020.ui.movie

import android.content.Intent
import com.example.movies2020.R
import com.example.movies2020.coremvp.BasePresenter
import com.example.movies2020.ui.movie.MovieContract.Companion.DATA_MOVIE_ID
import com.example.movies2020.utils.getStringByRes

/**
 * Created by Duy M. Nguyen on 4/30/2020.
 */
class MoviePresenter : BasePresenter<MovieContract.View>(), MovieContract.Presenter {

    private val interactor = MovieInteractor()

    var movieID: String? = null

    override fun getDataFromIntent(intent: Intent) {
        movieID = intent.getStringExtra(DATA_MOVIE_ID)
    }

    override fun getMovieDetail() {
        mView?.showLoading()
        if (movieID.isNullOrEmpty()) {
            mView?.dismiissLoading()
            mView?.showError(getStringByRes(R.string.movie_not_found))
        } else {
            interactor.getMovieDetail(
                movieID!!,
                {
                    mView?.dismiissLoading()
                    mView?.showMovieDetail(it)
                },
                {
                    mView?.dismiissLoading()
                    mView?.showError(it)
                }
            )
        }
    }
}