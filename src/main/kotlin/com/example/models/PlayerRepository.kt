package com.example.models

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*

class PlayerRepository(client: MongoClient) : PlayerRepositoryInterface<Player> {
    override lateinit var collection: MongoCollection<Player>

    init {
        val database = client.getDatabase("betclic")
        collection = database.getCollection<Player>("player")
    }

}