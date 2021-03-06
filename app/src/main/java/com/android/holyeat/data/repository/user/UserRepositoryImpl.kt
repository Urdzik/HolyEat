package com.android.holyeat.data.repository.user

import com.android.holyeat.data.database.DatabaseApi
import com.android.holyeat.data.model.NutritionistModel
import com.android.holyeat.data.model.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val databaseApi: DatabaseApi) : UserRepository {

    override suspend fun getUser(): Flow<UserModel> {
        return databaseApi.getUser().map { it.reversed()[0] }
    }

    override suspend fun setUser(data: UserModel): Long {
     return  databaseApi.insertUser(data)
    }
}