package com.sanjayprajapat.glidecacheapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanjayprajapat.glidecacheapp.databinding.FragmentHomeBinding
import com.sanjayprajapat.glidecacheapp.databinding.FragmentPicturesBinding
import kotlin.random.Random


/**
 * A simple [Fragment] subclass.
 * Use the [PicturesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PicturesFragment : Fragment() {

    val picturesAdapter by lazy {
        PicturesAdapter(arrayListOf())
    }
    var binding:FragmentPicturesBinding? = null
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
        // Inflate the layout for this fragment
        binding = FragmentPicturesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.picRecyclerView?.adapter = picturesAdapter
        picturesAdapter.updateData(getPicturesList())

        binding?.swiperefresh?.setOnRefreshListener {
            picturesAdapter.updateData(getPicturesList())
            binding?.swiperefresh?.isRefreshing = false
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PicturesFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun getPicturesList():ArrayList<Pictures>{
        val pics = ArrayList<Pictures>()
        val urls = getUrls()
//        val arr = ArrayList<Int>()
        for(i in 0..urls.size){
            val num = (0 until urls.size).random()
            pics.add(Pictures(id = i , url = urls[num]))
//            arr.add(num)
        }
        return pics
    }

    fun getUrls():ArrayList<String>{
        val urls = arrayListOf("https://media.istockphoto.com/photos/global-connection-picture-id1335295270?b=1&k=20&m=1335295270&s=170667a&w=0&h=PNF6QH5FyD_XvDbn4nHtIVKdmmlN86fCHTgwvkZYvHA=",
            "https://media.istockphoto.com/photos/paperless-workplace-idea-esigning-electronic-signature-document-an-picture-id1349390515?b=1&k=20&m=1349390515&s=170667a&w=0&h=d9eagqJMGdGExzPlpxp1UdhHi23NJTubYzKB4zPTs_s="
            ,"https://media.istockphoto.com/photos/productivity-powered-by-digital-technology-picture-id1330965067?b=1&k=20&m=1330965067&s=170667a&w=0&h=ys_MV3zYkn2HJCtHC4s_03Sz1MUC2BZv6PcDdk__XSc="
            ,"https://images.unsplash.com/photo-1598128558393-70ff21433be0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=900&q=60"
            ,"https://images.unsplash.com/photo-1591154669695-5f2a8d20c089?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=900&q=60"
            ,"https://images.unsplash.com/photo-1624555130581-1d9cca783bc0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8dXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=900&q=60"
            ,"https://images.unsplash.com/photo-1605496036006-fa36378ca4ab?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8dXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=900&q=60"
            ,"https://images.unsplash.com/photo-1584713503693-bb386ec95cf2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8dXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=900&q=60"
            ,"https://images.unsplash.com/photo-1584714268709-c3dd9c92b378?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8dXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=900&q=60"
            ,"https://images.unsplash.com/photo-1651319088177-8f2b83c6438a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fHVybHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=900&q=60"
            ,"https://media.istockphoto.com/photos/smiling-indian-business-man-working-on-laptop-at-home-office-young-picture-id1307615661?b=1&k=20&m=1307615661&s=170667a&w=0&h=Zp9_27RVS_UdlIm2k8sa8PuutX9K3HTs8xdK0UfKmYk="
            ,"https://media.istockphoto.com/photos/talking-and-working-on-video-calling-picture-id1340561120?b=1&k=20&m=1340561120&s=170667a&w=0&h=bxyTW6Ch9f7FbZSG38Scp4syPOaV69DWgXM4GswPoew="
            ,"https://media.istockphoto.com/photos/cute-teenager-girl-stock-photo-picture-id1346198479?k=20&m=1346198479&s=612x612&w=0&h=c3VskuOw-l95sWnR1Q9coAJvOGDalwgI-TaiOs9K9i4="
            ,"https://media.istockphoto.com/photos/young-student-stock-photo-picture-id1338845337?k=20&m=1338845337&s=612x612&w=0&h=Oh51Zecr1e-fuoU9HrmgT0vVasWUDnF_GOzP5pe22V8="
            ,"https://media.istockphoto.com/photos/business-technology-internet-and-networking-concept-picture-id1016968886?k=20&m=1016968886&s=612x612&w=0&h=IszCDh5YuntJLvzlHTUWCjW21SnBWvhPjrbpg46FiYI="
            ,"https://media.istockphoto.com/photos/young-woman-in-yoga-pose-using-laptop-at-home-picture-id1334071264?k=20&m=1334071264&s=612x612&w=0&h=DXHuw8VT4tlRJBEfWRa9WYTCnEt0FiqLAtO7Tgs0VJg="
            ,"https://media.istockphoto.com/photos/data-protection-and-secure-online-payments-cyber-internet-security-picture-id1227400166?k=20&m=1227400166&s=612x612&w=0&h=qCUxwAjrRf9fZR7qAi--femJiAG-WUHMaOHp0DDHDxc="
            ,"https://media.istockphoto.com/photos/female-doctor-stock-phtoo-picture-id1293909058?k=20&m=1293909058&s=612x612&w=0&h=WBNggbi2Sg5ud4hxeGF_YTl7uZukqNTAb3mV1v8Yd0M="
            ,"https://media.istockphoto.com/photos/time-to-get-growing-picture-id1153350345?k=20&m=1153350345&s=612x612&w=0&h=G-3HWepDXd74OiFIZNjG3gjqevoPWzOtI4YL4aeD7l4="
            ,"https://media.istockphoto.com/photos/womens-hand-typing-on-mobile-smartphone-live-chat-chatting-on-web-picture-id1217093906?k=20&m=1217093906&s=612x612&w=0&h=C_GFUdkBDSaf0nYGiyTxyA3A4zLowOcS31ZI-XOPQlc="
            ,"https://media.istockphoto.com/photos/man-applying-for-visa-online-picture-id938423222?k=20&m=938423222&s=612x612&w=0&h=C1F2MqVojA9HNTa8DScfRH52NjGC3bPRxDaGjzrYM0k=")

        return urls
    }
}