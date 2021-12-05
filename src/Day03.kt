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


  fun part2(input: List<Int>): Int = input.windowed(4)
    .count { it.first() < it.last() }

  val input = readInput("Day03")
  println(part1(input))
//  println(part2(input))
}
