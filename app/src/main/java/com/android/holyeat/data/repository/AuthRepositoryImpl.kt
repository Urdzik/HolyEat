package com.android.holyeat.data.repository

import com.android.holyeat.data.firebase.AuthFirebaseManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authFirebaseManager: AuthFirebaseManager) : AuthRepository {

    override suspend fun login(email: String, password: String, result: (result: Pair<Boolean, String>) -> Unit) {
        authFirebaseManager.login(email, password, result)
    }

    override suspend fun currentUser(): Flow<Boolean> {
        return authFirebaseManager.getCurrentUser()
    }
}