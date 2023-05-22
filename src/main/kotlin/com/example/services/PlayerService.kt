package com.example.services

import com.example.models.Player
import com.example.models.PlayerRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.UUID

class PlayerService : KoinComponent {
    val repository: PlayerRepository by inject()

    fun getAllPlayersByScore(){
        repository.getAll().sortedByDescending { it.score }
    }

    fun getPlayer(id: String): Player {
        return repository.getById(id)
    }

    fun addPlayer(playerEntry: Player): Player {
        val uuid = UUID.randomUUID().toString()
        val player = Player(
            id = uuid,
            name = playerEntry.name
        )
        return repository.add(player)
    }

    fun updatePlayerScore(id: String, score: Int): Player {
        val player = repository.getById(id)
        val playerUpdates = Player(
            id = player.id,
            name = player.name,
            score = score
        )
        return repository.update(playerUpdates)
    }

    fun deleteAllPlayers(){
        repository.deleteAll()
    }
}
