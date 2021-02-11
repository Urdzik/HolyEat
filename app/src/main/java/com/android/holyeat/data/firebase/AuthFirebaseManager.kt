package com.android.holyeat.data.firebase

import kotlinx.coroutines.flow.Flow

interface AuthFirebaseManager {
    suspend fun getCurrentUser(): Flow<Boolean>
    suspend fun login(
        email: String,
        password: String,
        result: (result: Pair<Boolean, String>) -> Unit
    )
}