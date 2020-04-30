package com.example.movies2020.ui.movie

import android.content.Intent
import com.example.movies2020.coremvp.BaseView
import com.example.movies2020.model.Movie

/**
 * Created by Duy M. Nguyen on 4/30/2020.
 */
class MovieContract {
    interface View : BaseView {
        fun showMovieDetail(movie: Movie)
        fun showError(message: String)
    }

    interface Presenter {
        fun getDataFromIntent(intent: Intent)
        fun getMovieDetail()
    }

    interface Interactor {
        fun getMovieDetail(
            movieID: String,
            successCallback: (Movie) -> Unit,
            failedCallback: (String) -> Unit
        )
    }

    companion object {
        const val DATA_MOVIE_ID = "DataMovieID"
    }
}