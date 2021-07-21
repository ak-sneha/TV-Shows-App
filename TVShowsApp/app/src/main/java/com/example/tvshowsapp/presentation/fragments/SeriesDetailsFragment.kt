package com.example.tvshowsapp.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.core.domain.TVSeries
import com.example.tvshowsapp.R
import com.example.tvshowsapp.databinding.FragmentSeriesDetailsBinding
import com.example.tvshowsapp.framework.NetworkInfo
import com.example.tvshowsapp.presentation.extensions.toast


private const val ARG_TITLE = "title"
private const val ARG_RATINGS = "ratings"
private const val ARG_DETAILS = "details"
private const val ARG_IMAGE = "image"

class SeriesDetailsFragment : Fragment() {
    private var title: String? = null
    private var ratings: String? = null
    private var details: String? = null
    private var imageUrl: String? = null

    private lateinit var binding: FragmentSeriesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            ratings = it.getString(ARG_RATINGS)
            details = it.getString(ARG_DETAILS)
            imageUrl = it.getString(ARG_IMAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeriesDetailsBinding.inflate(layoutInflater, container, false)

        initUi()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun initUi() {
        binding.tvShowName.text = title
        binding.tvRatings.text = " ${getString(R.string.ratings)} $ratings"
        binding.tvShowDetails.movementMethod = ScrollingMovementMethod()
        binding.tvShowDetails.text = HtmlCompat.fromHtml(details ?: "", 0)
        if (context?.let { NetworkInfo.isNetworkAvailable(it) } == true) {
            imageUrl?.let {
                Glide.with(this)
                    .load(it)
                    .into(binding.ivBcackground)
            }
            binding.progressBar.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            toast(getString(R.string.network_error))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(item: TVSeries) =
            SeriesDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, item.name ?: " ")
                    putString(ARG_RATINGS, item.rating?.average.toString())
                    putString(ARG_DETAILS, item.summary ?: " ")
                    putString(ARG_IMAGE, item.image?.original ?: " ")
                }
            }
    }
}