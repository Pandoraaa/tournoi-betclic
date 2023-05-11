package com.example.routes

import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.playerRouting() {
    val mongoBD = MongoDBPlayerRepository()
    route("/players") {
        get {
            mongoBD.getAllPlayersByRanking()
        }
        get("{id?}") {
            val playerId = call.parameters["id"]?.toIntOrNull() ?: return@get call.respond(HttpStatusCode.BadRequest)
            val player = mongoBD.getPlayerById(playerId) ?: return@get call.respond(HttpStatusCode.NotFound)
            call.respond(player)
        }

        post {
            val player = call.receive<Player>()
            mongoBD.addPlayer(player)
        }

        put {

        }
        delete {
            mongoBD.deleteAllPlayers()
        }
    }
}
