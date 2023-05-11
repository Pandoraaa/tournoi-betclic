package com.example.models

import com.mongodb.client.AggregateIterable
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*

class MongoDBPlayerRepository : PlayerRepository {

    private val client = KMongo.createClient()

    private val database = client.getDatabase("players")

    private val playersCollection = database.getCollection<Player>()

    override fun addPlayer(player: Player) {
        playersCollection.insertOne(player)
    }

    override fun getAllPlayersByScore(): AggregateIterable<Player> {
        return playersCollection.aggregate<Player>(
            sort(descending(Player::score))
        )
    }

    override fun updatePlayerScore(player: Player) {
        playersCollection.updateOne(Player::id eq player.id, setValue(Player::score, player.score))
    }

    override fun getPlayerById(id: Int): Player? {
        return playersCollection.findOneById(id)
    }

    override fun deleteAllPlayers() {
        playersCollection.drop()
    }

}