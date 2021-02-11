package com.android.holyeat.data.repository.user

import com.android.holyeat.data.model.NutritionistModel
import com.android.holyeat.data.model.UserModel
import kotlinx.coroutines.flow.Flow


interface UserRepository {

    suspend fun getUser(): Flow<UserModel>
    suspend fun setUser(data: UserModel): Long
}