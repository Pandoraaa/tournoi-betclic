package com.example.models

import java.util.UUID

fun Player.toDto(): PlayerDto =
    PlayerDto(
        id = this.id.toString(),
        name = this.name,
    )
fun PlayerDto.toPlayer(): Player =
    Player(
        name = this.name
    )