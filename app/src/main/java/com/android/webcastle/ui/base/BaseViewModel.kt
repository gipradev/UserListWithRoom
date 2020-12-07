package com.android.webcastle.ui.base

import androidx.lifecycle.ViewModel

open class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel() {
}