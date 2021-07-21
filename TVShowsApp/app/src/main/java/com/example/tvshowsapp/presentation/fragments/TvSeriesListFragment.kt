package com.example.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.core.domain.TVSeries
import com.example.tvshowsapp.R
import com.example.tvshowsapp.databinding.FragmentSeriesListBinding
import com.example.tvshowsapp.framework.NetworkInfo
import com.example.tvshowsapp.presentation.adapter.TvSeriesListAdapter
import com.example.tvshowsapp.presentation.extensions.init
import com.example.tvshowsapp.presentation.extensions.observeWith
import com.example.tvshowsapp.presentation.extensions.toast
import com.example.tvshowsapp.presentation.viewmodel.MainViewModel

class TvSeriesListFragment : Fragment() {

    private lateinit var showsAdapter: TvSeriesListAdapter

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentSeriesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSeriesListBinding.inflate(layoutInflater, container, false)

        initUi()
        observeViewModel()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (context?.let { NetworkInfo.isNetworkAvailable(it) } == true) {
            viewModel.getShows()
        } else {
            binding.progressBar.visibility = View.GONE
            toast(getString(R.string.network_error));
        }
    }

    private fun initUi() {
        context?.let {
            TvSeriesListAdapter(it) { item: TVSeries ->
            viewModel.selectItem(item)
            }.also { showsAdapter = it }
        }
        binding.recyclerView.init(adapter = showsAdapter)
    }

    private fun observeViewModel() = with(viewModel) {
        mutableTvSeriesList.observeWith(viewLifecycleOwner) {
            it.let { showsAdapter.add(it as MutableList<TVSeries>)
                binding.progressBar.visibility = View.GONE}
        }
    }

}