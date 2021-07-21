/*
 * Copyright 2019 nuhkoca.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tvshowsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.TVSeries
import com.example.tvshowsapp.framework.Interactors
import kotlinx.coroutines.launch

class MainViewModel(val interactors: Interactors) : ViewModel() {


    val mutableTvSeriesList = MutableLiveData<List<TVSeries>>()
//    val tvSeriesList: LiveData<List<TVSeries>> get() = mutableTvSeriesList

    private val mutableSelectedItem = MutableLiveData<TVSeries>()
    val selectedItem: LiveData<TVSeries> get() = mutableSelectedItem

    fun getShows() {
        viewModelScope.launch { mutableTvSeriesList.postValue(interactors.getTvSeries.invoke()) }
    }

    fun selectItem(item: TVSeries) {
        mutableSelectedItem.value = item
    }
}
