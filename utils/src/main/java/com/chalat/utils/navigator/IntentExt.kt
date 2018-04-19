package com.chalat.utils.navigator

import android.content.Intent

/**
 * Created by Chalat on 1/10/18.
 */
fun Intent.putExtra(key: String, value: Any?) {
    when (value) {
        is Int -> this.putExtra(key, value)
        is String -> this.putExtra(key, value)
    }
}