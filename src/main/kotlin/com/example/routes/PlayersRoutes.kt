package com.example.routes

import com.example.models.getPlayerById
import com.example.requests.PlayerRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.playersRouting() {
    route("/players") {
        get {
            // Repository KMongo get all
            call.respondText("Hello Betclic!")
        }
        get("{id?}") {
            val playerId = call.receive<PlayerRequest>().id
            val player = getPlayerById(playerId)
            player?.let {
                call.respond(
                    HttpStatusCode.OK,
                    it
                )
            } ?: call.respond(
                HttpStatusCode.OK,
                "There is no player with this id"
            )
        }

        post {

        }
        delete {

        }
    }
}
