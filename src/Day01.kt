fun main() {
  fun part1(input: List<Int>) = input.windowed(2)
    .count { (first, second) -> first < second }


  fun part2(input: List<Int>): Int = input.windowed(4)
    .count { it.first() < it.last() }

  val input = readIntInput("Day01")
  println(part1(input))
  println(part2(input))
}
