package com.android.webcastle.data.repository

import android.content.Context
import com.android.webcastle.data.network.WebService
import com.android.webcastle.data.room.AppDatabase
import com.android.webcastle.data.room.UserDao
import com.android.webcastle.data.room.UserTable
import com.android.webcastle.ui.base.BaseRepository

class SplashRepository(
    private val api: WebService,
    private val context: Context
) : BaseRepository() {

    private var userDao: UserDao? = null
    private var appDataBase: AppDatabase? = null

    init {
        appDataBase = AppDatabase.getDatabase(context)
        userDao = appDataBase?.UserDao()


    }

    suspend fun getUserFromServer() = safeApiCall {
        api.getUserList()
    }

    suspend fun requestInsertUser(userTable: UserTable) = safeApiCall {
        userDao?.insertUser(userTable)
    }

}