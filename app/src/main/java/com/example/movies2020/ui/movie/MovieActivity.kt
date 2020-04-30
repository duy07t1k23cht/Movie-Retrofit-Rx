package com.example.movies2020.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.movies2020.R
import com.example.movies2020.coremvp.BaseActivity
import com.example.movies2020.model.Movie
import com.example.movies2020.utils.toast
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity<MoviePresenter>(), MovieContract.View {

    override fun getLayoutId(): Int {
        return R.layout.activity_movie
    }

    override fun initPresenter(): MoviePresenter {
        return MoviePresenter()
    }

    override fun init() {
        mPresenter.getDataFromIntent(intent)
        mPresenter.getMovieDetail()
    }

    override fun showMovieDetail(movie: Movie) {
        // set poster
        Glide
            .with(this)
            .load(movie.poster)
            .into(iv_poster)

        // title
        tv_title.text = movie.title

        // other info
        tv_year.text = movie.year
        tv_type.text = movie.type
        tv_actor.text = movie.actors
    }

    override fun showError(message: String) {
        toast(message)
    }
}
