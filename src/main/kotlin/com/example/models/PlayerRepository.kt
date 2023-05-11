package com.example.models

interface PlayerRepository {

    suspend fun addPlayer(player: Player)

    suspend fun getAllPlayersByRanking(): Any

    suspend fun updatePlayerScore(player: Player)

    suspend fun getPlayerById(id: Int): Player?

    suspend fun deleteAllPlayers()
}