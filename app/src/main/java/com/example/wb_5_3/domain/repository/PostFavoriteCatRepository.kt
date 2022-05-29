package com.example.wb_5_3.domain.repository

import com.example.wb_5_3.domain.model.CatModelDomain

interface PostFavoriteCatRepository {

    suspend fun postCat(cat: CatModelDomain): Boolean

}