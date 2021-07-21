package com.example.tvshowsapp.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tvshowsapp.databinding.ActivityMainBinding
import com.example.tvshowsapp.presentation.adapter.ShowsListAdapter
import com.example.tvshowsapp.presentation.extensions.init
import com.example.tvshowsapp.presentation.extensions.observeWith
import com.example.tvshowsapp.presentation.extensions.toast
import com.example.tvshowsapp.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var showsAdapter: ShowsListAdapter

    private val viewModel: MainViewModel by viewModels { defaultViewModelProviderFactory }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        observeViewModel()
        viewModel.getShows()
    }

    private fun initUi() {
        ShowsListAdapter { item: String -> toast("Item clicked $item") }.also { showsAdapter = it }
        binding.recyclerView.init(adapter = showsAdapter)
    }

    private fun observeViewModel() = with(viewModel) {
        showsData.observeWith(this@MainActivity) {

            it.let { showsAdapter.add(it as MutableList<String>) }
        }
    }
}





