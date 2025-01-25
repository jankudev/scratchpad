package dev.janku.learning.interview

typealias Board = Array<CharArray>
typealias Coords = Pair<Int, Int>

/**
 * Finding the direct passes through the board and all the exits from a starting point.
 *
 * Given a MxN board with barriers '+' and open spaces '0' fin all the direct passes from any side.
 * Return the list of such passable rows / columns.
 *
 * hint: Find the rows and columns fully composed of open spaces '0'.
 */
class BoardPassthrough {

  companion object {
    enum class BOARD_SYMBOL(val symbol: Char) {
      BARRIER('+'),
      OPEN_SPACE('0')
    }
  }

  fun findPassableRows(board: Board): List<Int> {
    if (board.isEmpty()) return emptyList()

    return (0 until board.size)
      .filter { row ->
        board[row].all { boardSymbol -> boardSymbol == BOARD_SYMBOL.OPEN_SPACE.symbol }
      }.toList()
  }

  fun findPassableColumns(board: Board): List<Int> {
    if (board.isEmpty()) return emptyList()

    return (0 until board[0].size)
      .filter { column ->
        board.map { row -> row[column] }.all { boardSymbol -> boardSymbol == BOARD_SYMBOL.OPEN_SPACE.symbol }
    }.toList()
  }

  /**
   * Find all the direct passable lanes on the board.
   * @param board - the board to search for passable lanes
   * @return pair of lists of passable rows and columns
   */
  fun findDirectPassableLanes(board: Board): Pair<List<Int>,List<Int>> {
    return Pair(findPassableRows(board), findPassableColumns(board))
  }

  /**
   * Find all the possible exits from the board starting from the given coordinates.
   * @param board - the board to search for exits
   * @param startCoords - the starting coordinates
   * @return list of exit coordinates
   */
  fun findExits(board: Board, startCoords: Coords): List<Coords> {

    val queue = listOf<Coords>().toMutableList()
    val exits = listOf<Coords>().toMutableList()
    val processed = setOf<Coords>().toMutableSet()

    if (board[startCoords.first][startCoords.second] == BOARD_SYMBOL.OPEN_SPACE.symbol) {
      queue.add(startCoords)
    }

    while(queue.isNotEmpty()) {
      val current = queue.removeFirst()
      processed.add(current)

      // if current is on the edge of the board, it's an exit
      if (current.first in listOf(0, board.size - 1) || current.second in listOf(0, board[0].size - 1)) {
        exits.add(current)
      }

      // try 4 directions from the current position and if not out of bounds, not a barrier and not processed, add to the queue
      for (direction in listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))) {
        val next = Pair(current.first + direction.first, current.second + direction.second)

        if (next.first >=0 && next.first < board.size && next.second >=0 && next.second < board[0].size
          && board[next.first][next.second] == BOARD_SYMBOL.OPEN_SPACE.symbol
          && !processed.contains(next)) {
          queue.add(next)
        }
      }
    }

    return exits
  }
}