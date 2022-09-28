package io.github.regbl.characters.service.responses

data class Saves(
    val breath: Int,
    val magic: Int,
    val poison: Int,
    val stone: Int,
    val wands: Int
)

fun Saves.toSaves(): io.github.regbl.characters.data.model.Saves {
    return io.github.regbl.characters.data.model.Saves(
        wands = this.wands,
        breath = this.breath,
        stone = this.stone,
        magic = this.magic,
        poison = this.poison
    )
}