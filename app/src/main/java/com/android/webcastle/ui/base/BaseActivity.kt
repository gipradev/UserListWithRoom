package com.android.webcastle.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel, R : BaseRepository> :
    AppCompatActivity() {
    protected lateinit var binding: DB
    protected lateinit var viewModel: VM
   // protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getActivityView())
       // viewModel = ViewModelProvider(this).get(getViewModel())

    }

    abstract fun getActivityView(): Int
    abstract fun getViewModel(): Class<VM>
    abstract fun getRepository(): R
}