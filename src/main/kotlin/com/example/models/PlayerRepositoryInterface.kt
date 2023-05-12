package com.example.models
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne
import java.lang.Exception

interface PlayerRepositoryInterface<T> {

    var collection: MongoCollection<T>

    fun getById(id: String): T {
        return try {
            collection.findOne(Player::id eq id)
                ?: throw Exception("No player with that ID exists")
        } catch (t: Throwable) {
            throw Exception("Cannot get player")
        }
    }

    fun getAll(): List<T> {
        return try {
            val res = collection.find().sort({"score":-1})
            res.asIterable().map { it }
        } catch (t: Throwable) {
            throw Exception("Cannot get all players")
        }
    }

    fun deleteAll() {
        collection.drop()
    }

    fun add(entry: T): T {
        return try {
            collection.insertOne(entry)
            entry
        } catch (t: Throwable) {
            throw Exception("Cannot add player")
        }
    }

    fun update(entry: Player): T {
        return try {
            collection.updateOne(
                Player::id eq entry.id,
                entry
            )
            collection.findOne(Player::id eq entry.id)
                ?: throw Exception("No player with that ID exists")
        } catch (t: Throwable) {
            throw Exception("Cannot update player")
        }
    }
}