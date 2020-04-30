package com.example.movies2020.ui.main

import com.example.movies2020.coremvp.BasePresenter
import com.example.movies2020.coremvp.BaseView
import com.example.movies2020.model.Movie

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
class MainContract {

    interface View : BaseView {
        fun showListMovie(listMovie: MutableList<Movie>)
        fun showMoreMovie(listMovie: MutableList<Movie>)
        fun showError(message: String)
    }

    interface Presenter {
        fun searchMovie(query: String)
        fun searchNextPage()
    }

    interface Interactor {
        fun searchMovie(
            query: String,
            page: Int,
            successCallback: (MutableList<Movie>) -> Unit,
            failedCallback: (String) -> Unit
        )

        fun getMovieDetail(
            movieID: String,
            successCallback: (Movie) -> Unit,
            failedCallback: (String) -> Unit
        )
    }
}