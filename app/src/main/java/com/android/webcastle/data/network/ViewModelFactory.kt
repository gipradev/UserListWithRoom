package com.android.webcastle.data.network

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.webcastle.data.repository.AppDatabaseRepository
import com.android.webcastle.data.repository.HomeRepository
import com.android.webcastle.data.repository.SplashRepository
import com.android.webcastle.ui.base.BaseRepository
import com.android.webcastle.ui.home.HomeViewModel
import com.android.webcastle.ui.home.SplashScreenViewModel


@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val context: Context,
    private val repository: BaseRepository,
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(
                context,
                repository as HomeRepository
            ) as T

            modelClass.isAssignableFrom(SplashScreenViewModel::class.java) -> SplashScreenViewModel(
                context,
                repository as SplashRepository
            ) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}