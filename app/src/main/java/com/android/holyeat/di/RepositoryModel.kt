package com.android.holyeat.di

import com.android.holyeat.data.database.DatabaseApi
import com.android.holyeat.data.firebase.AuthFirebaseManager
import com.android.holyeat.data.repository.auth.AuthRepository
import com.android.holyeat.data.repository.auth.AuthRepositoryImpl
import com.android.holyeat.data.repository.nutritionist.NutritionistRepository
import com.android.holyeat.data.repository.nutritionist.NutritionistRepositoryImpl
import com.android.holyeat.data.repository.user.UserRepository
import com.android.holyeat.data.repository.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [FirebaseModule::class, DatabaseModule::class])
object RepositoryModel {

    @Provides
    fun provideAuthRepository(authFirebaseManager: AuthFirebaseManager): AuthRepository {
        return AuthRepositoryImpl(authFirebaseManager)
    }

    @Provides
    fun provideNutritionistRepository(databaseApi: DatabaseApi): NutritionistRepository{
        return NutritionistRepositoryImpl(databaseApi)
    }

    @Provides
    fun provideUserRepository(databaseApi: DatabaseApi): UserRepository {
        return UserRepositoryImpl(databaseApi)
    }
}