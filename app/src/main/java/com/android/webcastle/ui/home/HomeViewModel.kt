package com.android.webcastle.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.webcastle.data.model.Data
import com.android.webcastle.data.model.UserModel
import com.android.webcastle.data.network.Resource
import com.android.webcastle.data.repository.HomeRepository
import com.android.webcastle.data.room.AppDatabase
import com.android.webcastle.data.room.UserTable
import com.android.webcastle.ui.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(
    private val context: Context,
    private val repository: HomeRepository,
) : BaseViewModel(repository) {

    val userResponse: LiveData<Resource<List<Data?>?>> = MutableLiveData()

    fun getUserlistFromDB() = viewModelScope.launch {
        userResponse as MutableLiveData
        userResponse.value = repository.getUserFromDB()
    }


}