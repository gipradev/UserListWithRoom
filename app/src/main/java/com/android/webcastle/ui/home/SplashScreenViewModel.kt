package com.android.webcastle.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.webcastle.data.model.UserModel
import com.android.webcastle.data.network.Resource
import com.android.webcastle.data.repository.HomeRepository
import com.android.webcastle.data.repository.SplashRepository
import com.android.webcastle.data.room.UserTable
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    private val context: Context,
    private val repository: SplashRepository,
) : ViewModel() {

    val apiResponse: LiveData<Resource<UserModel>> = MutableLiveData()

    fun requestUserList() =
        viewModelScope.launch {
            Log.e("HomeFragment", "requestUserList")
            apiResponse as MutableLiveData
            apiResponse.value = repository.getUserFromServer()

        }

    fun addUser(userTable: UserTable) = viewModelScope.launch {
        repository.requestInsertUser(userTable)
        //AppDatabaseRepository(context).requestInsertUser(userTable)
    }
}