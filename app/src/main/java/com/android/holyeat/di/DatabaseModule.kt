package com.android.holyeat.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.holyeat.data.database.DatabaseApi
import com.android.holyeat.data.database.HolyEatDatabase
import com.android.holyeat.data.model.NutritionistModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

   lateinit  var database: HolyEatDatabase

    @Provides
    fun provideDatabase(@ApplicationContext app: Context) : HolyEatDatabase {
        database = Room
            .databaseBuilder(app, HolyEatDatabase::class.java , HolyEatDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    GlobalScope.launch {
                        database.dao().insertNutritionist(
                            listOf(
                                NutritionistModel(
                                    year = 5,
                                    name = "Павло Васильєв",
                                    description = "",
                                    cost = 850,
                                    rank = "лікар-дієтолог",
                                    rating = 3.5F,
                                    image = "https://image.prntscr.com/image/gYq1XAriTY_nalFdPoolTw.jpeg"
                                ),
                                NutritionistModel(
                                    year = 11,
                                    name = "Микола Краменко",
                                    description = "",
                                    cost = 950,
                                    rank = "лікар-дієтолог",
                                    rating = 4.5F,
                                    image = "https://image.prntscr.com/image/Opz-_QJHS5yZafvuFpUfKQ.jpeg"
                                ),
                                NutritionistModel(
                                    year = 8,
                                    name = "Кіра Пономарчук",
                                    description = "",
                                    cost = 1100,
                                    rank = "професійний дієтолог",
                                    rating = 5.0F,
                                    image = "https://image.prntscr.com/image/W_zt-XX7RAqo_bdItEXA8w.jpeg"
                                ),
                                NutritionistModel(
                                    year = 5,
                                    name = "Кириленко Хильда",
                                    description = "",
                                    cost = 650,
                                    rank = "лікар-дієтолог",
                                    rating = 3.0F,
                                    image = "https://image.prntscr.com/image/ReVvG5soRs_Jdp18GDdk1Q.jpeg"
                                ),
                                NutritionistModel(
                                    year = 3,
                                    name = "Савенко Доминик",
                                    description = "",
                                    cost = 500,
                                    rank = "лікар-дієтолог",
                                    rating = 4.0F,
                                    image = "https://image.prntscr.com/image/O8DhCisGQ9i4gRi7quz4cw.jpeg"
                                ),
                                NutritionistModel(
                                    year = 15,
                                    name = "Коровяк Эмилия",
                                    description = "",
                                    cost = 1500,
                                    rank = "професійний дієтолог",
                                    rating = 5.0F,
                                    image = "https://image.prntscr.com/image/zf8uRabITP_E6iL5c1Ks8w.jpeg"
                                ),
                            )
                        )
                    }
            }
            })
            .build()
        return database
    }

    @Provides
    fun provideProviderDao(database : HolyEatDatabase) : DatabaseApi {
        return database.dao()
    }

}