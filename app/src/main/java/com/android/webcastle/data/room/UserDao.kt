package com.android.webcastle.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.webcastle.data.model.Data
import com.android.webcastle.data.network.Resource

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg userTable: UserTable)

    @Query("SELECT * FROM USER_TABLE")
    fun getAllUsersFromDb(): List<Data?>?

}