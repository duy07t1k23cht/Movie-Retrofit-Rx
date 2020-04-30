package com.example.movies2020.utils

import android.content.res.Resources
import androidx.annotation.StringRes

/**
 * Created by Duy M. Nguyen on 4/30/2020.
 */

fun getStringByRes(@StringRes stringResID: Int): String {
    return Resources.getSystem().getString(stringResID)
}