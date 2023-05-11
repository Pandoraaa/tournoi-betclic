package com.example.models

import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class MongoDBPlayerRepository : PlayerRepository {
    private val client = KMongo.createClient("mongoDB").coroutine
    private val database = client.getDatabase("players")

    private val players = database.getCollection<Player>()

    override suspend fun addPlayer(player: Player) {
        players.insertOne(player)
    }

    override suspend fun getAllPlayersByRanking(): CoroutineCollection<Player> {
        // TODO ranking
        return players
    }

    override suspend fun updatePlayerScore(player: Player) {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerById(id: Int): Player? {
        return players.findOneById(id)
    }

    override suspend fun deleteAllPlayers() {
        players.drop()
    }

}