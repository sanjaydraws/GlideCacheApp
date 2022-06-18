package com.sanjayprajapat.glidecacheapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanjayprajapat.glidecacheapp.databinding.FragmentPicturesBinding
import com.sanjayprajapat.glidecacheapp.databinding.FragmentTransformationBinding
import com.sanjayprajapat.glidecacheapp.utils.Type
import com.sanjayprajapat.glidecacheapp.utils.Type.*

/**
 * A simple [Fragment] subclass.
 * Use the [TransformationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransformationFragment : Fragment() {

    val transformationAdapter by lazy {
        TransformationAdapter(arrayListOf())
    }
    var binding:FragmentTransformationBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransformationBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.picRecyclerView?.adapter = transformationAdapter

        transformationAdapter.updateData(getTypes())

    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransformationFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    fun getTypes():MutableList<Type>{
        val l = mutableListOf(
            Mask, NinePatchMask,
//            RoundedCorners,
            CropTop, CropCenter, CropBottom, CropSquare,
//            CropCircle,
//            CropCircleWithBorder, Grayscale, BlurLight, BlurDeep, Toon, Sepia, Contrast, Invert,
//            Pixel, Sketch, Swirl, Brightness, Kuawahara, Vignette
        )
        return  l
    }

}