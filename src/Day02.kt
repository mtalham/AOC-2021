fun main() {
  data class Operation(val direction: String, val amount: Int)

  fun part1(input: List<Operation>): Int {
    var depth = 0
    var horizontalPosition = 0
    input.forEach { (direction, amount) ->
      when (direction) {
        "up" -> depth -= amount
        "down" -> depth += amount
        "forward" -> horizontalPosition += amount
      }
    }
    return depth * horizontalPosition
  }

  fun part2(input: List<Operation>): Int {
    var aim = 0
    var depth = 0
    var horizontalPosition = 0
    input.forEach { (direction, amount) ->
      when (direction) {
        "up" -> aim -= amount
        "down" -> aim += amount
        "forward" -> {
          horizontalPosition += amount
          depth += aim * amount
        }
      }
    }
    return depth * horizontalPosition
  }

  val input = readInput("Day02")
    .map { it.split(' ') }
    .map { Operation(it[0], it[1].toInt()) }
  println(part1(input))
  println(part2(input))
}
