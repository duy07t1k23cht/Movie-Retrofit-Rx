package com.example.movies2020.coremvp

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
open class BasePresenter<V : BaseView> {

    protected var mView: V? = null

    fun attachView(view: V) {
        this.mView = view
    }

    fun detachView() {
        this.mView = null
    }
}