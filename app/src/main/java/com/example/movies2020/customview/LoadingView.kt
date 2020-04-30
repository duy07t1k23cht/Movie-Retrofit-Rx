package com.example.movies2020.customview

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import com.example.movies2020.R


class LoadingView(context: Context) :
    Dialog(context, R.style.LoadingView) {
    init {
        setContentView(R.layout.loading_view)
        window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
    }
}
