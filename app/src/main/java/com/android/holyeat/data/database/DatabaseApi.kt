package com.android.holyeat.data.database

import androidx.room.*
import com.android.holyeat.data.model.UserModel



@Dao
interface DatabaseApi {

    @Insert
    suspend fun insertUser(providerDatabaseModel: UserModel): Long



}