package com.example.mvvm_clean_architecture_paging3_hilt.common

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import coil.transform.RoundedCornersTransformation

fun ImageView.loadImage(url: String?) {
    val placeHolder = createPlaceHolder(this.context)
    this.load(url) {
        crossfade(true)
        crossfade(500)
        transformations(RoundedCornersTransformation(30f))
        placeholder(placeHolder)
    }
}
private fun createPlaceHolder(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 12f
        centerRadius = 40f
        start()
    }
}
