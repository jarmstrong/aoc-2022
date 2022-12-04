fun main() {
    fun splitInput(input: List<String>): List<String> {
        return input.map { "${it.first()}${it.last()}" }
    }

    fun List<String>.sumScores(): Int {
        val choiceScoreTable = mapOf(
            'X' to 1,
            'Y' to 2,
            'Z' to 3
        )

        val resultScores = mapOf(
            "AX" to 3,
            "AY" to 6,
            "AZ" to 0,
            "BX" to 0,
            "BY" to 3,
            "BZ" to 6,
            "CX" to 6,
            "CY" to 0,
            "CZ" to 3
        )

        return sumOf {
            val you = it.last()
            choiceScoreTable[you]!! + resultScores[it]!!
        }
    }

    fun part1(input: List<String>): Int {
        return splitInput(input).sumScores()
    }

    fun part2(input: List<String>): Int {
        val playbook = mapOf(
            "AX" to "AZ",
            "AY" to "AX",
            "AZ" to "AY",
            "BX" to "BX",
            "BY" to "BY",
            "BZ" to "BZ",
            "CX" to "CY",
            "CY" to "CZ",
            "CZ" to "CX"
        )

        return splitInput(input)
            .map { playbook[it]!! }
            .sumScores()
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
