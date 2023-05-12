package com.example.routes

import com.example.module
import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class PlayersRoutesKtTest {

    @Test
    fun testGetPlayers() = testApplication {
        application {
            configureRouting()
        }
        client.get("/players").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }
}