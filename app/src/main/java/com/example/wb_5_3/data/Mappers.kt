package com.example.wb_5_3.data

import com.example.wb_5_3.data.model.CatModelData
import com.example.wb_5_3.domain.model.CatModelDomain

fun CatModelData.toDomain(): CatModelDomain{
    return CatModelDomain(
        id = id,
        url = url
    )
}