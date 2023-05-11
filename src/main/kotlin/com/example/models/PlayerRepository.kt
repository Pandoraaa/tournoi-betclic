package com.example.models

interface PlayerRepository {

    fun addPlayer(player: Player)

    fun getAllPlayersByScore(): Any

    fun updatePlayerScore(player: Player)

    fun getPlayerById(id: Int): Player?

    fun deleteAllPlayers()
}