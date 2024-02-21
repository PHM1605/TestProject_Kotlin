var heroName: String = ""

val narrationModifier = {message:String->
    val numExclamationPoints = 3
    message.uppercase() + "!".repeat(numExclamationPoints)
}

fun narrate(
    message:String,
    modifier:(String)->String={narrationModifier(it)}
) {
    println(modifier(message))
}

fun main() {
    heroName = promptHeroName()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
}

private fun createTitle(name:String): String {
    return when {
        name.all{it.isDigit()} -> "The Identifiable"
        name.none {it.isLetter()} -> "The Witness Protection Member"
        name.count {it.lowercase() in "aeiou"} >4 -> "The Master of Vowels"
        else -> "The Renowned Hero"
    }
}


private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?") {
        message -> "\u001B[33;1m$message\u001B[0m"
    }
    println("Madrigal")
    return "Madrigal"
}