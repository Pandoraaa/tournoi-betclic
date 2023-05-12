package com.example.models

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*

class PlayerRepository(client: MongoClient) : PlayerRepositoryInterface<Player> {
    override lateinit var col: MongoCollection<Player>

    init {
        val database = client.getDatabase("betclic")
        col = database.getCollection<Player>("player")
    }

}