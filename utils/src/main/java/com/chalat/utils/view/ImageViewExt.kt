package com.chalat.utils.view

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions

/**
 *
 * Created by Chalat Chansima on 4/13/18.
 *
 */

fun ImageView.setImage(url: String, requestOptions: RequestOptions? = null) {
    val placeHolderRequestOptions = RequestOptions()
            .placeholder(android.R.color.darker_gray)
    Glide.with(this)
            .load(url)
            .apply(placeHolderRequestOptions)
            .apply(requestOptions)
            .into(this)
}

private fun RequestBuilder<Drawable>.apply(requestOptions: RequestOptions?): RequestBuilder<Drawable> {
    requestOptions?.let { this.apply(it) }
    return this
}