package com.example.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.tvshowsapp.databinding.FragmentShowListBinding
import com.example.tvshowsapp.presentation.adapter.ShowsListAdapter
import com.example.tvshowsapp.presentation.extensions.init
import com.example.tvshowsapp.presentation.extensions.observeWith
import com.example.tvshowsapp.presentation.extensions.toast
import com.example.tvshowsapp.presentation.viewmodel.MainViewModel

class ShowListFragment : Fragment() {

    private lateinit var showsAdapter: ShowsListAdapter

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentShowListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShowListBinding.inflate(layoutInflater, container, false)

        initUi()
        observeViewModel()
        viewModel.getShows()
        return binding.root
    }

    private fun initUi() {
        showsAdapter = ShowsListAdapter {
                item: String -> toast("Item clicked $item")
        viewModel.selectItem(item)
        }//.also { showsAdapter = it }
        binding.recyclerView.init(adapter = showsAdapter)
    }

    private fun observeViewModel() = with(viewModel) {
        showsData.observeWith(viewLifecycleOwner) {
            it.let { showsAdapter.add(it as MutableList<String>) }
        }
    }

}