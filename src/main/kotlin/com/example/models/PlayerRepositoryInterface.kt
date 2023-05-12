package com.example.models
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne
import java.lang.Exception

interface PlayerRepositoryInterface<T> {

    var col: MongoCollection<T>

    fun getById(id: String): T {
        return try {
            col.findOne(Player::id eq id)
                ?: throw Exception("No item with that ID exists")
        } catch (t: Throwable) {
            throw Exception("Cannot get item")
        }
    }

    fun getAll(): List<T> {
        return try {
            val res = col.find()
            res.asIterable().map { it }
        } catch (t: Throwable) {
            throw Exception("Cannot get all items")
        }
    }

    fun deleteAll() {
        col.drop()
    }

    fun add(entry: T): T {
        return try {
            col.insertOne(entry)
            entry
        } catch (t: Throwable) {
            throw Exception("Cannot add item")
        }
    }

    fun update(entry: Player): T {
        return try {
            col.updateOne(
                Player::id eq entry.id,
                entry
            )
            col.findOne(Player::id eq entry.id)
                ?: throw Exception("No item with that ID exists")
        } catch (t: Throwable) {
            throw Exception("Cannot update item")
        }
    }
}