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

class MainViewModel : ViewModel() {

    val showsData = MutableLiveData<List<String>>()

    private var tempList: List<String> = listOf()

    private val mutableSelectedItem = MutableLiveData<String>()
    val selectedItem: LiveData<String> get() = mutableSelectedItem


    init {
        tempList = listOf(
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6",
            "Item 7", "Item 8", "Item 9", "Item 10"
        )
    }

    fun getShows() {
        showsData.postValue(tempList)
    }

    fun selectItem(item: String) {
        mutableSelectedItem.value = item
    }
}
