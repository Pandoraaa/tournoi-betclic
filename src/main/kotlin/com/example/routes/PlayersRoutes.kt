package com.example.routes

import com.example.models.*
import com.example.services.PlayerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.playerRouting() {
    val playerService by inject<PlayerService>()

    route("/players") {
        get {
            playerService.getAllPlayersByScore()
        }
        get("/{id}") {
            val playerId = call.parameters["id"]?: return@get call.respond(HttpStatusCode.BadRequest)
            playerService.getPlayer(playerId)
        }

        post {
            val player = call.receive<Player>()
            playerService.addPlayer(player)
        }

        put("/{id}") {
            val playerId = call.parameters["id"]?: return@put call.respond(HttpStatusCode.BadRequest)
            val player = call.receive<Player>()
            playerService.updatePlayerScore(playerId, player.score)
        }
        delete {
            playerService.deleteAllPlayers()
        }
    }
}
