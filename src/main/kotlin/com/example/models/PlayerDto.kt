package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class PlayerDto(
    val id : String? = null,
    val name: String,
    val score: Int = 0,
    val ranking: Int = 1
)
