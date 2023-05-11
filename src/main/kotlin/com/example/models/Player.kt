package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val name: String,
    val score: Int = 0,
    val ranking: Int = 1
)
