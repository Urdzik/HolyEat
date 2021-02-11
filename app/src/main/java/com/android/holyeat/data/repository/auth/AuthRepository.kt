package com.android.holyeat.data.repository.auth

import kotlinx.coroutines.flow.Flow


interface AuthRepository {

    suspend fun login(
        email: String,
        password: String,
        result: (result: Pair<Boolean, String>) -> Unit
    )

    suspend fun signUp(
        email: String,
        password: String,
        result: (result: Pair<Boolean, String>) -> Unit
    )

    suspend fun currentUser(): Flow<Boolean>
}