package com.sanjayprajapat.glidecacheapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.sanjayprajapat.glidecacheapp.R
import jp.wasabeef.glide.transformations.BlurTransformation
import android.graphics.Bitmap
import android.util.Log

import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition


/**
 * Created By Sanjay Prajapat on 28-05-2022 at 10:56PM
 * github: https://github.com/sanjaydraws
 * blog:https://dev.to/sanjayprajapat/
 * */

/**
 * show placeholder when error or image load failed
 * */
fun getRequestOption(): RequestOptions {
    val requestOptions = RequestOptions()
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.drawpic)
    return requestOptions
}

/**
 * to blur transform
 * */
fun getBlurRequestOption():RequestOptions =
    RequestOptions.bitmapTransform( BlurTransformation(25, 5))
    .error(R.drawable.drawpic)


/**
 * @param imageUrl pass image url
 * */

@BindingAdapter("loadImage")
fun ImageView.loadImage1(imageUrl: Any?){
    imageUrl?.let {
        Glide.with(this).applyDefaultRequestOptions(getBlurRequestOption())
        .load(imageUrl).
        centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).
        placeholder(R.drawable.ic_launcher_background).
        into(this)
    }
}

/**
 * show blur images
 * */
@BindingAdapter("loadImage")
fun ImageView.blurLoadImage(imageUrl: Any?){
    Glide.with(this)
        .load(imageUrl)
        .apply( RequestOptions().centerCrop())
        .transform( BlurTransformation( 20, 1))
    .into(this);
}

/**
 * show blur image and then show original image
 * */
@BindingAdapter("loadImage")
fun ImageView.loadImage(imageUrl: Any?) {
    val thumbnailRequest = Glide.with(this)
        .load(imageUrl).centerCrop()
        .transform( BlurTransformation( 7, 1))

    Glide.with(this)
        .load(imageUrl)
        .thumbnail(thumbnailRequest)
         .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}


