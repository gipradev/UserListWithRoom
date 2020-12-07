package com.android.webcastle.data.repository

import android.content.Context
import android.util.Log
import androidx.annotation.WorkerThread
import com.android.webcastle.data.room.AppDatabase
import com.android.webcastle.data.room.UserDao
import com.android.webcastle.data.room.UserTable

class AppDatabaseRepository(private val context: Context) {

    private var userDao: UserDao? = null
    private var appDataBase: AppDatabase? = null

//    init {
//        appDataBase = AppDatabase(context)
//        userDao = appDataBase?.UserDao()
//    }

    suspend fun requestInsertUser(userTable: UserTable) {
        userDao?.insertUser(userTable)
        Log.i("HomeFragment","inserted")
    }

}