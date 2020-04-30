package com.example.movies2020.customview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
class LoadMoreRecyclerView : RecyclerView {

    private var isLoading = false
    private var allowLoadMore = true

    private var onLoadMore: (() -> Unit)? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    private fun init() {
        addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!allowLoadMore || isLoading) {
                    return
                }
                if (layoutManager is LinearLayoutManager && (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() + 1 == adapter?.itemCount) {
                    onLoadMore?.invoke()
                } else if (layoutManager is GridLayoutManager && (layoutManager as GridLayoutManager).findLastCompletelyVisibleItemPosition() + 1 == adapter?.itemCount) {
                    onLoadMore?.invoke()
                }
            }
        })
    }

    fun setLoading(loading: Boolean) {
        isLoading = loading
    }

    fun setAllowLoadMore(allowLoadMore: Boolean) {
        this.allowLoadMore = allowLoadMore
    }

    fun setOnLoadMoreListener(onLoadMore: (() -> Unit)) {
        this.onLoadMore = onLoadMore
    }
}