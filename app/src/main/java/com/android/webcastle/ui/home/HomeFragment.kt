package com.android.webcastle.ui.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.android.webcastle.R
import com.android.webcastle.data.model.Data
import com.android.webcastle.data.network.Resource
import com.android.webcastle.data.network.WebService
import com.android.webcastle.data.repository.HomeRepository
import com.android.webcastle.data.room.UserTable
import com.android.webcastle.databinding.HomeFragmentBinding
import com.android.webcastle.ui.adaptor.UserAdaptor
import com.android.webcastle.ui.base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding, HomeRepository>() {

    val userAdaptor: UserAdaptor by lazy { UserAdaptor() }

    override fun getFragmentView(): Int = R.layout.home_fragment

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getRepository(): HomeRepository =
        HomeRepository(remoteDataSource.buildApi(WebService::class.java), requireContext())

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.userRecyclerView.adapter = userAdaptor
        viewModel.getUserlistFromDB()
        observerRoomResponse()

    }

    fun observerRoomResponse() {

        viewModel.userResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> userAdaptor.userList = it.value
                is Resource.Failure -> {

                }
            }
        })
    }


}