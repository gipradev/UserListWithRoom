package com.android.webcastle.data.repository


import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.android.webcastle.data.network.WebService
import com.android.webcastle.data.room.AppDatabase
import com.android.webcastle.data.room.UserDao
import com.android.webcastle.data.room.UserTable
import com.android.webcastle.ui.base.BaseRepository


class HomeRepository(
    private val api: WebService,
    private val context: Context
) : BaseRepository() {

    private var userDao: UserDao? = null
    private var appDataBase: AppDatabase? = null

    init {
        appDataBase = AppDatabase.getDatabase(context)
        userDao = appDataBase?.UserDao()

    }


    suspend fun getUserFromDB() = safeApiCall {
        userDao?.getAllUsersFromDb()
    }


}