package com.example.requests

import kotlinx.serialization.Serializable

@Serializable
data class ScoreUpdateRequest(
    val score: Int
)
