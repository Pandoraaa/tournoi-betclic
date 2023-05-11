package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.playersRouting() {
    route("/players") {
        get {
            call.respondText("Hello Betclic!")
        }
        get("{name?}") {

        }
        post {

        }
        delete {

        }
    }
}