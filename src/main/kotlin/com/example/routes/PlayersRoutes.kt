package com.example.routes

import com.example.models.*
import com.example.services.PlayerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.playerRouting() {
val playerService = PlayerService()
    route("/players") {
        get {
            playerService.getAllPlayers()
        }
        get("/{id}") {
            val playerId = call.parameters["id"]?: return@get call.respond(HttpStatusCode.BadRequest)
            playerService.getPlayer(playerId)
        }

        post {
            val player = call.receive<Player>()
            playerService.addPlayer(player)
        }

        put {
            val player = call.receive<Player>()
            playerService.updatePlayerScore(player.id, player.score)
        }
        delete {
            playerService.deleteAllPlayers()
        }
    }
}
