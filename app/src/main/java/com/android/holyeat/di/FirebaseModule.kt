package com.android.holyeat.di

import com.android.holyeat.data.firebase.AuthFirebaseManager
import com.android.holyeat.data.firebase.AuthFirebaseManagerImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

    fun provideFirebaseAuth(): AuthFirebaseManager {
        return AuthFirebaseManagerImpl()
    }
}