package interview

import dev.janku.learning.interview.BoardPassthrough
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class BoardPassthroughTest {

  companion object {
    val board1 = arrayOf(
      charArrayOf('+', '+', '+', '+', '+', '+', '+', '0', '0'),
      charArrayOf('+', '+', '0', '0', '0', '0', '0', '+', '+'),
      charArrayOf('0', '0', '0', '0', '0', '+', '+', '0', '+'),
      charArrayOf('+', '+', '0', '+', '+', '+', '+', '0', '0'),
      charArrayOf('+', '+', '0', '0', '0', '0', '0', '0', '+'),
      charArrayOf('+', '+', '0', '+', '+', '0', '+', '0', '+'))

    val board2 = arrayOf(
      charArrayOf('+', '+', '+', '+', '+', '+', '+'),
      charArrayOf('0', '0', '0', '0', '+', '0', '+'),
      charArrayOf('+', '0', '+', '0', '+', '0', '0'),
      charArrayOf('+', '0', '0', '0', '+', '+', '+'),
      charArrayOf('+', '+', '+', '+', '+', '+', '+'))

    val board3 = arrayOf(
      charArrayOf('+', '0', '+', '0', '+'),
      charArrayOf('0', '0', '+', '0', '0'),
      charArrayOf('+', '0', '+', '0', '+'),
      charArrayOf('0', '0', '+', '0', '0'),
      charArrayOf('+', '0', '+', '0', '+'))

    val board4 = arrayOf(
      charArrayOf('+', '0', '+', '0', '+'),
      charArrayOf('0', '0', '0', '0', '0'),
      charArrayOf('+', '+', '+', '+', '+'),
      charArrayOf('0', '0', '0', '0', '0'),
      charArrayOf('+', '0', '+', '0', '+'))

    val board5 = arrayOf(
      charArrayOf('+', '0', '0', '0', '+'),
      charArrayOf('+', '0', '+', '0', '0'),
      charArrayOf('+', '0', '0', '0', '0'),
      charArrayOf('+', '0', '0', '0', '+'))

    val board6 = arrayOf(
      charArrayOf('+', '+', '+', '+', '+', '+', '+', '+'),
      charArrayOf('0', '0', '0', '0', '0', '0', '0', '0'),
      charArrayOf('+', '0', '0', '0', '0', '0', '0', '0'),
      charArrayOf('+', '0', '0', '0', '0', '0', '0', '+'),
      charArrayOf('0', '0', '0', '0', '0', '0', '0', '+'),
      charArrayOf('+', '+', '+', '+', '+', '+', '0', '+'))
  }

  /* Direct passthroughs */

  @Test
  fun `empty board`() {
    assertEquals(Pair(emptyList(), emptyList()), BoardPassthrough().findDirectPassableLanes(emptyArray()))
  }

  @Test
  fun `single place board - no passthrough`() {
    assertEquals(Pair(emptyList(), emptyList()), BoardPassthrough().findDirectPassableLanes(arrayOf(charArrayOf('+'))))
  }

  @Test
  fun `single place board - passthrough`() {
    assertEquals(Pair(listOf(0), listOf(0)), BoardPassthrough().findDirectPassableLanes(arrayOf(charArrayOf('0'))))
  }

  @Test
  fun `example board 1`() {
    assertEquals(Pair(emptyList(), emptyList()), BoardPassthrough().findDirectPassableLanes(board1))
  }

  @Test
  fun `example board 2`() {
    assertEquals(Pair(emptyList(), emptyList()), BoardPassthrough().findDirectPassableLanes(board2))
  }

  @Test
  fun `example board 3`() {
    assertEquals(Pair(emptyList(), listOf(1,3)), BoardPassthrough().findDirectPassableLanes(board3))
  }

  @Test
  fun `example board 4`() {
    assertEquals(Pair(listOf(1,3), emptyList()), BoardPassthrough().findDirectPassableLanes(board4))
  }

  @Test
  fun `example board 5`() {
    assertEquals(Pair(emptyList(), listOf(1,3)), BoardPassthrough().findDirectPassableLanes(board5))
  }

  @Test
  fun `example board 6`() {
    assertEquals(Pair(listOf(1), emptyList()), BoardPassthrough().findDirectPassableLanes(board6))
  }

  /* Exits */
  @Test
  fun `exits of board 1 - multiple start positions`() {
    val start1_1 = Pair(2, 0)
    assertContentEquals(
      listOf(Pair(2, 0), Pair(5, 2), Pair(5, 5), Pair(5, 7), Pair(3, 8)),
      BoardPassthrough().findExits(board1, start1_1))

    val start1_2 = Pair(0, 7)
    assertContentEquals(
      listOf(Pair(0, 7), Pair(0, 8)),
      BoardPassthrough().findExits(board1, start1_2))
  }

  @Test
  fun `exits of board 2 - multiple start positions`() {
    val start1_1 = Pair(1, 0)
    assertContentEquals(
      listOf(Pair(1, 0)),
      BoardPassthrough().findExits(board2, start1_1))

    val start1_2 = Pair(2, 6)
    assertContentEquals(
      listOf(Pair(2, 6)),
      BoardPassthrough().findExits(board2, start1_2))
  }

  @Test
  fun `exits of board 3 - multiple start positions - 2 different segments`() {
    val start1_1 = Pair(1, 0)
    assertContentEquals(
      listOf(Pair(1, 0), Pair(0, 1), Pair(3, 0), Pair(4, 1)),
      BoardPassthrough().findExits(board3, start1_1))

    val start1_2 = Pair(1, 4)
    assertContentEquals(
      listOf(Pair(1, 4), Pair(0, 3), Pair(3, 4), Pair(4, 3)),
      BoardPassthrough().findExits(board3, start1_2))
  }
}