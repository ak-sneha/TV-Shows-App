package com.example.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tvshowsapp.databinding.FragmentShowDetailsBinding

private const val ARG_SELECTED_ITEM = "selected_item"

class ShowDetailsFragment : Fragment() {
    private var item: String? = null

    private lateinit var binding: FragmentShowDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            item = it.getString(ARG_SELECTED_ITEM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowDetailsBinding.inflate(layoutInflater, container, false)

        initUi()
        return binding.root
    }

    private fun initUi() {
        binding.tvShowName.text = item
    }

    companion object {

        @JvmStatic
        fun newInstance(item: String) =
            ShowDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_SELECTED_ITEM, item)
                }
            }
    }
}