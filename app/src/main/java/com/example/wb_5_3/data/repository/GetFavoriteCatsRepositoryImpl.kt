package com.example.wb_5_3.data.repository

import com.example.wb_5_3.data.network.CatApiHelper
import com.example.wb_5_3.domain.model.CatModelDomain
import com.example.wb_5_3.domain.repository.GetFavoriteCatsRepository
import javax.inject.Inject

class GetFavoriteCatsRepositoryImpl @Inject constructor(private val apiHelper: CatApiHelper):
    GetFavoriteCatsRepository{

    override suspend fun getFavoriteCats(): List<CatModelDomain> {
        return apiHelper.getFavoriteCats()
    }

}