package com.example.wb_5_3.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatFavoriteModelData(
    @SerialName("id")
    val id: Int,

    @SerialName("image")
    val image: CatModelData
)
