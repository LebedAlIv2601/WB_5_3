package com.example.wb_5_3.data.repository

import com.example.wb_5_3.data.network.CatApiHelper
import com.example.wb_5_3.domain.model.CatModelDomain
import com.example.wb_5_3.domain.repository.PostFavoriteCatRepository
import javax.inject.Inject

class PostFavoriteCatRepositoryImpl @Inject constructor(private val apiHelper: CatApiHelper) :
    PostFavoriteCatRepository {

    override suspend fun postCat(cat: CatModelDomain): Boolean {
        return apiHelper.postCat(cat)
    }
}