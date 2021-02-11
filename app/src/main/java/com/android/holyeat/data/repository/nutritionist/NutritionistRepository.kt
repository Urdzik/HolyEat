package com.android.holyeat.data.repository.nutritionist

import com.android.holyeat.data.model.NutritionistModel
import kotlinx.coroutines.flow.Flow


interface NutritionistRepository {

    suspend fun getNutritionists(): Flow<List<NutritionistModel>>
}