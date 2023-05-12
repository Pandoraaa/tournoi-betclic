package com.example.plugins

import com.example.routes.playerRouting
import com.example.services.PlayerService
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello Betclic!")
        }
        playerRouting()
    }
}
