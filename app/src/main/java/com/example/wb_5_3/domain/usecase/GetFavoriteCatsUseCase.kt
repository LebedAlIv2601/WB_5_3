package com.example.wb_5_3.domain.usecase

import com.example.wb_5_3.domain.model.CatModelDomain
import com.example.wb_5_3.domain.repository.GetFavoriteCatsRepository
import javax.inject.Inject

class GetFavoriteCatsUseCase @Inject constructor(private val repository: GetFavoriteCatsRepository) {

    suspend fun execute(): List<CatModelDomain>{
        return repository.getFavoriteCats()
    }

}