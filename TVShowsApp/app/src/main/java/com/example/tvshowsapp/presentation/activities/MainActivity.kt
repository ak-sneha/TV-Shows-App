package com.example.tvshowsapp.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.tvshowsapp.R
import com.example.tvshowsapp.databinding.ActivityMainBinding
import com.example.tvshowsapp.framework.TvShowsViewModelFactory
import com.example.tvshowsapp.presentation.extensions.observeWith
import com.example.tvshowsapp.presentation.fragments.SeriesDetailsFragment
import com.example.tvshowsapp.presentation.fragments.TvSeriesListFragment
import com.example.tvshowsapp.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels { TvShowsViewModelFactory }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, TvSeriesListFragment())
            }
        }

        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        selectedItem.observeWith(this@MainActivity) {

            it.let {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container_view, SeriesDetailsFragment.newInstance(it))
                    setReorderingAllowed(true)
                    addToBackStack("list")
//                    setReorderingAllowed(true)
//                    add(R.id.fragment_container_view, ShowListFragment())
                }
            }
        }
    }
}





