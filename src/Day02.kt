fun main() {
  fun part1(input: List<String>): Int {
    var depth = 0
    var horizontalPosition = 0
    input.map { it.split(' ') }.forEach { (direction, amount) ->
      when (direction) {
        "up" -> depth -= amount.toInt()
        "down" -> depth += amount.toInt()
        "forward" -> horizontalPosition += amount.toInt()
      }
    }
    return depth * horizontalPosition
  }

  fun part2(input: List<String>): Int {
    var aim = 0
    var depth = 0
    var horizontalPosition = 0
    input.map { it.split(' ') }.forEach { (direction, amountString) ->
      val amount = amountString.toInt()
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
  println(part1(input))
  println(part2(input))
}
