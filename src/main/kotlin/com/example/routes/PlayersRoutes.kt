package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.playersRouting() {
    route("/players") {
        get {
            // Repository KMongo get all
            call.respondText("Hello Betclic!")
        }
        get("{id?}") {

        }
        post {

        }
        delete {

        }
    }
}