fun main() {
  fun part1(input: List<String>): Int {
    var gamma = ""
    var epsilon = ""
    (0 until input[0].length).forEach { index ->
      run {
        val ones: Int = input.count { it[index].toString() == "1" }
        if (input.size / 2 < ones) {
          gamma = gamma.plus(1)
          epsilon = epsilon.plus(0)
        } else {
          gamma = gamma.plus(0)
          epsilon = epsilon.plus(1)
        }
      }
    }

    return gamma.toInt(2) * epsilon.toInt(2)
  }

  fun rating(input: List<String>, isOxygen: Boolean): String {
    var candidates = input
    for (column in 0 until input[0].length) {
      val (zeros, ones) = candidates.countBitsInColumn(column)
      val mostCommon = if (zeros > ones) '0' else '1'
      candidates = candidates.filter {
        when (isOxygen) {
          true -> it[column] == mostCommon
          false -> it[column] != mostCommon
        }
      }
      if (candidates.size == 1) break
    }
    return candidates.single()
  }

  fun part2(input: List<String>): Int {
    return rating(input, true).toInt(2) * rating(input, false).toInt(2)
  }


  val input = readInput("Day03")
  println(part1(input))
  println(part2(input))
}

private fun List<String>.countBitsInColumn(column: Int): Pair<Int, Int> {
  var zeros = 0
  var ones = 0
  for (line in this) {
    if (line[column] == '0') zeros++ else ones++
  }
  return zeros to ones
}
