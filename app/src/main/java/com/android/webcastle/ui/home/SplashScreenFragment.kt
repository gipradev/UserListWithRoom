package com.android.webcastle.ui.home

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.android.webcastle.R
import com.android.webcastle.data.model.Data
import com.android.webcastle.data.network.Resource
import com.android.webcastle.data.network.WebService
import com.android.webcastle.data.repository.SplashRepository
import com.android.webcastle.data.room.UserTable
import com.android.webcastle.databinding.SplashScreenFragmentBinding
import com.android.webcastle.ui.base.BaseFragment

class SplashScreenFragment :
    BaseFragment<SplashScreenViewModel, SplashScreenFragmentBinding, SplashRepository>() {

    override fun getFragmentView(): Int = R.layout.splash_screen_fragment

    override fun getViewModel(): Class<SplashScreenViewModel> = SplashScreenViewModel::class.java

    override fun getRepository(): SplashRepository {
        return SplashRepository(remoteDataSource.buildApi(WebService::class.java), requireContext())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lottieCrop.playAnimation()
        viewModel.requestUserList()
        observeApiResponse()
    }

    fun observeApiResponse() {

        viewModel.apiResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {

                    val data: List<Data> = it.value.data
                    data.forEach {
                        val userTable: UserTable = UserTable(
                            id = it.id,
                            email = it.email,
                            avatar = it.avatar,
                            first_name = it.first_name,
                            last_name = it.last_name
                        )
                        viewModel.addUser(userTable)
                    }
                }
                is Resource.Failure -> {

                }
            }
            navigateToHome()
        })

    }

    fun navigateToHome() {
        Handler().postDelayed({
            binding.lottieCrop.pauseAnimation()
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }, 5000)
    }

}