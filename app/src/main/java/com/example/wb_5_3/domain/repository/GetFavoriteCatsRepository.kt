package com.example.wb_5_3.domain.repository

import com.example.wb_5_3.domain.model.CatModelDomain

interface GetFavoriteCatsRepository {

    suspend fun getFavoriteCats(): List<CatModelDomain>

}