package com.sanjayprajapat.glidecacheapp

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.RequestOptions.overrideOf
import com.sanjayprajapat.glidecacheapp.databinding.ItemPicturesBinding
import com.sanjayprajapat.glidecacheapp.databinding.ItemTransformationBinding
import com.sanjayprajapat.glidecacheapp.utils.Type
import com.sanjayprajapat.glidecacheapp.utils.loadImage
import com.sanjayprajapat.glidecacheapp.utils.px
import jp.wasabeef.glide.transformations.CropTransformation
import jp.wasabeef.glide.transformations.MaskTransformation
import com.sanjayprajapat.glidecacheapp.utils.Type.*
import jp.wasabeef.glide.transformations.CropSquareTransformation

class TransformationAdapter (var transformationList: List<Type>? = null ): RecyclerView.Adapter<TransformationAdapter.VideosVH>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransformationAdapter.VideosVH {
        val binding = ItemTransformationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideosVH(binding)
    }

    fun updateData(transformationList: List<Type>?) {
        this.transformationList = transformationList
        notifyDataSetChanged()
    }

//    companion object : DiffUtil.ItemCallback<Directories>() {
//        override fun areItemsTheSame(oldItem: Directories, newItem: Directories): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Directories, newItem: Directories): Boolean {
//            return oldItem.id == newItem.id && oldItem.dirName == newItem.dirName
//        }
//    }


    override fun getItemCount(): Int {
        return transformationList?.size ?: 0
    }

    override fun onBindViewHolder(holder: TransformationAdapter.VideosVH, position: Int) {
        holder.loadData(transformationList?.get(position))
    }

    inner class VideosVH(val binding: ItemTransformationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val url = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Hapus_Mango.jpg/330px-Hapus_Mango.jpg"
        fun loadData(transformType: Type?) {
            when (transformType) {
                Type.Mask -> {
                    Glide.with(binding.imgpic.context)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Hapus_Mango.jpg/330px-Hapus_Mango.jpg")
                        .apply(overrideOf(266.px, 252.px))
                        .apply(
                            bitmapTransform(
                                MultiTransformation<Bitmap>(
                                    CenterCrop(),
                                    MaskTransformation(R.drawable.mask_starfish)
                                )
                            )
                        )
                        .into(binding.imgpic)
                }
                Type.NinePatchMask -> {
                    Glide.with(binding.imgpic.context)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Hapus_Mango.jpg/330px-Hapus_Mango.jpg")
                        .apply(overrideOf(300.px, 200.px))
                        .apply(
                            bitmapTransform(
                                MultiTransformation<Bitmap>(
                                    CenterCrop(),
                                    MaskTransformation(R.drawable.mask_chat_right)
                                )
                            )
                        ) .into(binding.imgpic)
                }
                CropTop -> Glide.with(binding.imgpic.context)
                    .load(url)
                    .apply(bitmapTransform(CropTransformation(300.px, 100.px, CropTransformation.CropType.TOP)))
                    .into(binding.imgpic)

                CropCenter -> Glide.with(binding.imgpic.context)
                    .load(url)
                    .apply(bitmapTransform(CropTransformation(300.px, 100.px, CropTransformation.CropType.CENTER)))
                    .into(binding.imgpic)

                CropBottom -> Glide.with(binding.imgpic.context)
                    .load(url)
                    .apply(bitmapTransform(CropTransformation(300.px, 100.px, CropTransformation.CropType.BOTTOM)))
                    .into(binding.imgpic)

                CropSquare -> Glide.with(binding.imgpic.context)
                    .load(url)
                    .apply(bitmapTransform(CropSquareTransformation()))
                    .into(binding.imgpic)

            }
        }
    }
}