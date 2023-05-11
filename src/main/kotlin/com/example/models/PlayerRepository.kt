package com.example.models

interface PlayerRepository {

    fun addPlayer(player: Player)

    fun getAllPlayersByRanking(): Any

    fun updatePlayerScore(player: Player)

    fun getPlayerById(id: Int): Player?

    fun deleteAllPlayers()
}