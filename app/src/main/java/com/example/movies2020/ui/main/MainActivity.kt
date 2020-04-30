package com.example.movies2020.ui.main

import android.util.Log
import androidx.appcompat.widget.SearchView
import com.example.movies2020.R
import com.example.movies2020.coremvp.BaseActivity
import com.example.movies2020.model.Movie
import com.example.movies2020.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainContract.View {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun init() {
        setupSearchViews()
        setupRecyclerViews()
    }

    private fun setupSearchViews() {
        search_movie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query.isNullOrEmpty())
                    return false

                mPresenter.searchMovie(query)

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun setupRecyclerViews() {
        rv_movies.hasFixedSize()

        rv_movies.setOnLoadMoreListener {
            mPresenter.searchNextPage()
        }
    }

    override fun showListMovie(listMovie: MutableList<Movie>) {
        val adapter = MovieAdapter(this, listMovie)
        rv_movies.adapter = adapter
    }

    override fun showMoreMovie(listMovie: MutableList<Movie>) {
        var adapter = rv_movies.adapter
        if (adapter == null) {
            adapter = MovieAdapter(this, listMovie)
            rv_movies.adapter = adapter
        }
        (adapter as? MovieAdapter)?.addMovie(listMovie)
    }

    override fun showError(message: String) {
        toast("Error: $message")
        Log.e("__ERR__", message)
    }
}
