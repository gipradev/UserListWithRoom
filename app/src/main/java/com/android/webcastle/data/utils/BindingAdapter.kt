package com.android.webcastle.data.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.android.webcastle.R


/**
 * File for declaring custom binding methods
 */

/**
 * Image binding
 */



@BindingAdapter("coilLoader")
fun coilLoader(view: ImageView, imageUrl: String?) {
    view.load(imageUrl) {
        transformations(RoundedCornersTransformation(10f))
        placeholder(R.mipmap.ic_place_holder)
    }
}

@BindingAdapter("coilImageLoader")
fun coilImageLoader(view: ImageView, imageUrl: String?) {
    view.load(imageUrl) {
        placeholder(R.mipmap.ic_place_holder)
    }
}




