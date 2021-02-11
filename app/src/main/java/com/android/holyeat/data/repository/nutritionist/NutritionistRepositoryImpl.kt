package com.android.holyeat.data.repository.nutritionist

import com.android.holyeat.data.database.DatabaseApi
import com.android.holyeat.data.firebase.AuthFirebaseManager
import com.android.holyeat.data.model.NutritionistModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NutritionistRepositoryImpl @Inject constructor(private val databaseApi: DatabaseApi) : NutritionistRepository {
    override suspend fun getNutritionists(): Flow<List<NutritionistModel>> {
        return databaseApi.getNutritionists()
    }


}