fun main() {
    data class SectionIDRange(val startSectionId: Int, val endSectionId: Int)
    data class ElfPair(val firstElf: SectionIDRange, val secondElf: SectionIDRange)

    fun List<String>.createElfPairs(): List<ElfPair> {
        return map {
            val linePair = it.split(",").map { rangeString ->
                val range = rangeString.split("-")
                SectionIDRange(range.first().toInt(), range.last().toInt())
            }
            ElfPair(linePair.first(), linePair.last())
        }
    }

    fun part1(input: List<String>): Int {
        return input
            .createElfPairs()
            .count {
                (it.firstElf.startSectionId >= it.secondElf.startSectionId && it.firstElf.endSectionId <= it.secondElf.endSectionId) ||
                        (it.secondElf.startSectionId >= it.firstElf.startSectionId && it.secondElf.endSectionId <= it.firstElf.endSectionId)
            }
    }

    fun part2(input: List<String>): Int {
        return input
            .createElfPairs()
            .count {
                val firstRange = (it.firstElf.startSectionId..it.firstElf.endSectionId).toSet()
                val secondRange = (it.secondElf.startSectionId..it.secondElf.endSectionId).toSet()
                firstRange.intersect(secondRange).isNotEmpty()
            }
    }

    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
