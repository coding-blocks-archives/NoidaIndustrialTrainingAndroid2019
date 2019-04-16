package com.codingblocks.okhttpgson

class Root(
    val abilities: ArrayList<Ability>,
    val base_experience: Int,
    val forms: ArrayList<Form>,
    val game_indices: ArrayList<GameIndex>,
    val height: Double,
    val id: Int,
    val is_default: Boolean,
    val moves: ArrayList<Move>,
    val name: String,
    val order: Int,
    val species: Form,
    val sprites: Sprites,
    val stats: ArrayList<Stat>,
    val types: ArrayList<Type>,
    val weight: Double
)

class Type(
    val slot: Int,
    val type: Form
)

class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: Form
)

class Sprites(
    val front_default: String,
    val back_default: String
)

class Move(
    val move: Form
)

class GameIndex(
    val game_index: Int,
    val version: Form
)

class Ability(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: Form
)

class Form(
    val name: String,
    val url: String
)