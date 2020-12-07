package com.android.webcastle.data.network


import com.android.webcastle.data.model.UserModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("/api/users")
    suspend fun getUserList(
        @Query("page") page: String = "2"
    ): UserModel
}