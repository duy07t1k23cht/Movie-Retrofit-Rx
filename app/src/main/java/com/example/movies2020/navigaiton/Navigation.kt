package com.example.movies2020.navigaiton

import android.app.Activity
import android.content.Intent
import com.example.movies2020.ui.movie.MovieActivity
import com.example.movies2020.ui.movie.MovieContract.Companion.DATA_MOVIE_ID
import com.example.movies2020.ui.movie.MoviePresenter

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
object Navigation {

    /**
     * @param activity: current activity
     * @param movieID: movie ID
     */
    fun toMovieActivity(activity: Activity, movieID: String) {
        val intent = Intent(activity, MovieActivity::class.java)

        intent.putExtra(DATA_MOVIE_ID, movieID)

        activity.startActivity(intent)
    }
}