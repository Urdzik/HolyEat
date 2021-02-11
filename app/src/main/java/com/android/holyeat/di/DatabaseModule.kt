package com.android.holyeat.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.holyeat.data.database.DatabaseApi
import com.android.holyeat.data.database.HolyEatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) : HolyEatDatabase {
        return Room
            .databaseBuilder(app, HolyEatDatabase::class.java , HolyEatDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(object :RoomDatabase.Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                }
            })
            .build()
    }

    @Singleton
    @Provides
    fun provideProviderDao(database : HolyEatDatabase) : DatabaseApi {
        return database.dao()
    }

}