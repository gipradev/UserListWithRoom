package com.android.webcastle.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.webcastle.data.network.RemoteDataSource
import com.android.webcastle.data.network.ViewModelFactory


abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding, R : BaseRepository> : Fragment() {
    protected lateinit var binding: DB
    protected lateinit var viewModel: VM
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, getFragmentView(), container, false
        )
        val factory = ViewModelFactory(binding.root.context,getRepository())
        viewModel = ViewModelProvider(this,factory).get(getViewModel())
//        viewModel = ViewModelProvider(this).get(getViewModel())
        return binding.root
    }

    abstract fun getFragmentView(): Int
    abstract fun getViewModel(): Class<VM>
    abstract fun getRepository(): R


}