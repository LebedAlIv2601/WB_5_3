package com.example.wb_5_3.domain.repository

import com.example.wb_5_3.domain.model.CatModelDomain

interface GetCatRepository {

    suspend fun getCat(): CatModelDomain

}