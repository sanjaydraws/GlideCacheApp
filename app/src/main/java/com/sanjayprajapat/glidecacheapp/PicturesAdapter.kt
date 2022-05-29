package com.sanjayprajapat.glidecacheapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanjayprajapat.glidecacheapp.databinding.ItemPicturesBinding
import com.sanjayprajapat.glidecacheapp.utils.loadImage


class PicturesAdapter (var picturesList: List<Pictures>? = null ): RecyclerView.Adapter<PicturesAdapter.VideosVH>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PicturesAdapter.VideosVH {
        val binding = ItemPicturesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideosVH(binding)
    }

    fun updateData(picturesList: List<Pictures>?) {
        this.picturesList = picturesList
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
        return picturesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: PicturesAdapter.VideosVH, position: Int) {
        holder.loadData(picturesList?.get(position))
    }

    inner class VideosVH(val binding: ItemPicturesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun loadData(picturesData: Pictures?) {
//            val animation = AnimationUtils.loadAnimation(binding?.root.context, R.anim.recycler_view_animation)
            binding.imgpic.loadImage( picturesData?.url)
            binding.imgpic.setOnClickListener {
//                mListener?.onImageClick(photoUri = statusData?.url)
            }
//            binding?.root.startAnimation(animation)
        }
    }
}