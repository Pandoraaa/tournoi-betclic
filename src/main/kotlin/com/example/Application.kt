package com.example

import com.example.di.mainModule
import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.core.context.startKoin

fun main(args: Array<String>) {
    startKoin {
        modules(mainModule)
    }
    // Start Ktor
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}
@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureRouting()
}
