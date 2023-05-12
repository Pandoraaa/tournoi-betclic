package com.example.di

import com.example.models.PlayerRepository
import com.example.services.PlayerService
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import javax.annotation.processing.ProcessingEnvironment

val mainModule = module(createdAtStart = true) {
    single { KMongo.createClient("mongodb+srv://betclic:Ox7v1aRVzsXstnJh@betclic.bahz8ci.mongodb.net/betclic?retryWrites=true&w=majority") }
    single { PlayerService() }
    single { PlayerRepository(get()) }
}