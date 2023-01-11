package io.github.regbl.characters.data.model

data class Attributes(
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int
) {
    companion object {
        fun fromAttributeMap(attributes: List<List<Any>>): Attributes {
            val attributesMap = attributes.associate {
                it.component1() as String to (it.component2() as Double).toInt()
            }
            return Attributes(
                strength = (attributesMap["STR"] ?: 0),
                dexterity = (attributesMap["DEX"] ?: 0),
                constitution = (attributesMap["CON"] ?: 0),
                intelligence = (attributesMap["INT"] ?: 0),
                wisdom = (attributesMap["WIS"] ?: 0),
                charisma = (attributesMap["CHA"] ?: 0)
            )
        }
    }
}