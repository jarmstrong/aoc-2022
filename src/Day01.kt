fun main() {
    fun calorieCountsByElf(input: List<String>): Map<Int, Int> {
        var currentElfIndex = 0
        val elfCalorieCounts = mutableMapOf<Int, Int>()
        input.forEach {
            if (it.isEmpty()) {
                currentElfIndex++
                return@forEach
            }

            val currentCalorieCount = elfCalorieCounts.getOrDefault(currentElfIndex, 0)
            elfCalorieCounts[currentElfIndex] = currentCalorieCount + it.toInt()
        }
        return elfCalorieCounts
    }

    fun part1(input: List<String>): Int {
        return calorieCountsByElf(input).values.max()
    }

    fun part2(input: List<String>): Int {
        return calorieCountsByElf(input).values.sorted().takeLast(3).sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
