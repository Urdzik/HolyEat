package com.android.holyeat.di

import com.android.holyeat.data.firebase.AuthFirebaseManager
import com.android.holyeat.data.repository.AuthRepository
import com.android.holyeat.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [FirebaseModule::class])
object RepositoryModel {

    @Provides
    fun provideAuthRepository(authFirebaseManager: AuthFirebaseManager): AuthRepository{
        return AuthRepositoryImpl(authFirebaseManager)
    }
}