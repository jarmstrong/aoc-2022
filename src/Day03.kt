fun main() {
    val scores = (('a'..'z') + ('A'..'Z'))
        .zip(1..52)
        .toMap()

    fun part1(input: List<String>): Int {
        return input.sumOf { rucksack ->
            val firstCompartment = rucksack.substring(0, rucksack.length / 2).toSet()
            val secondCompartment = rucksack.substring(rucksack.length / 2).toSet()
            firstCompartment
                .intersect(secondCompartment)
                .sumOf { scores[it]!! }
        }
    }

    fun part2(input: List<String>): Int {
        return input
            .chunked(3)
            .sumOf {
                it[0].toSet()
                    .intersect(it[1].toSet())
                    .intersect(it[2].toSet())
                    .sumOf { scores[it]!! }
            }
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
