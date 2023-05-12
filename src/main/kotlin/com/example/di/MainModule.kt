package com.example.di

import com.example.models.PlayerRepository
import com.example.services.PlayerService
import org.koin.dsl.module
import org.litote.kmongo.KMongo

val mainModule = module(createdAtStart = true) {
    factory { KMongo.createClient(System.getenv("MONGO_URI") ?: "") }
    single { PlayerService() }
    single { PlayerRepository(get()) }
}