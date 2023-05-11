package com.example.models

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


private val client = KMongo.createClient().coroutine
private val database = client.getDatabase("PlayerDatabase")

private val players = database.getCollection<Player>()

suspend fun getPlayerById(id: String): Player? {
    return players.findOneById(id)
}
