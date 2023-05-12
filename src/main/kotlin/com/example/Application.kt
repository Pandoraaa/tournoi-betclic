package com.example

import com.example.di.mainModule
import io.ktor.server.application.*
import com.example.plugins.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureRouting()
}

fun Application.main() {
    // Install Ktor features
    install(Koin) {
        slf4jLogger()
        modules(mainModule)
    }
}


