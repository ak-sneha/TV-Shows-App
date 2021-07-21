package com.example.tvshowsapp.framework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tvshowsapp.presentation.viewmodel.MainViewModel

object TvShowsViewModelFactory: ViewModelProvider.Factory {

    lateinit var dependencies: Interactors

    fun inject(dependencies: Interactors) {
        this.dependencies = dependencies
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(MainViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Interactors::class.java)
                .newInstance(dependencies)
        } else {
            throw IllegalStateException("ViewModel must extend MajesticViewModel")
        }
    }
}