package com.example.movies2020.ui.main

import com.example.movies2020.coremvp.BasePresenter

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {

    private val interactor = MainInteractor()

    var currentQuery = ""
    var currentPage = 1

    override fun searchMovie(query: String) {
        currentQuery = query
        currentPage = 1

        mView?.showLoading()

        interactor.searchMovie(
            currentQuery,
            currentPage,
            {
                mView?.showListMovie(it)
                mView?.dismiissLoading()
            },
            {
                mView?.showError(it)
                mView?.dismiissLoading()
            }
        )
    }

    override fun searchNextPage() {
        currentPage++

        interactor.searchMovie(
            currentQuery,
            currentPage,
            {
                mView?.showMoreMovie(it)
            },
            {
                mView?.showError(it)
            }
        )
    }
}