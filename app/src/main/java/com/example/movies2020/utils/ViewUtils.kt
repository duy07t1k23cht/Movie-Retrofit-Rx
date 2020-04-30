package com.example.movies2020.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */

fun Context?.toast(message: String) {
    this?.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}

fun Context?.toast(@StringRes stringResID: Int) {
    this?.let {
        Toast.makeText(it, getString(stringResID), Toast.LENGTH_SHORT).show()
    }
}