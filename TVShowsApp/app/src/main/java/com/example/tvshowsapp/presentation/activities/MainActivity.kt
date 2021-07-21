package com.example.tvshowsapp.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.tvshowsapp.R
import com.example.tvshowsapp.databinding.ActivityMainBinding
import com.example.tvshowsapp.presentation.extensions.observeWith
import com.example.tvshowsapp.presentation.fragments.ShowDetailsFragment
import com.example.tvshowsapp.presentation.fragments.ShowListFragment
import com.example.tvshowsapp.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels { defaultViewModelProviderFactory }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, ShowListFragment())
            }
        }

        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        selectedItem.observeWith(this@MainActivity) {

            it.let {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container_view, ShowDetailsFragment.newInstance(it))
                    setReorderingAllowed(true)
                    addToBackStack("list")
//                    setReorderingAllowed(true)
//                    add(R.id.fragment_container_view, ShowListFragment())
                }
            }
        }
    }
}





