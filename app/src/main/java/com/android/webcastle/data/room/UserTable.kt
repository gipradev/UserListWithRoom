package com.android.webcastle.data.room

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserTable(

    @PrimaryKey
    @NonNull
    val id: Int,

    val avatar: String,

    val email: String,

    val first_name: String,

    val last_name: String
)
