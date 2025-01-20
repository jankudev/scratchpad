package problems.slidingWindow

import dev.janku.learning.problems.slidingWindow.SmallestSubArrayWithSum
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SmallestSubArrayWithSumTest {
  /* Naive way - functional trying all possible windows from smallest */
  @Test
  fun `smallest sub-array with sum - empty array should behave as when it does not exist (returns 0)`() {
    assertEquals(0, SmallestSubArrayWithSum.findLength_naive(intArrayOf(), 5))
  }

  @Test
  fun `smallest sub-array with sum - when sum does not exist return 0`() {
    assertEquals(0, SmallestSubArrayWithSum.findLength_naive(intArrayOf(2, 4, 6, 8), 11))
  }

  @Test
  fun `smallest sub-array with sum - when single such sub-array exists`() {
    assertEquals(2, SmallestSubArrayWithSum.findLength_naive(intArrayOf(2, 4, 6, 8), 10))
  }

  @Test
  fun `smallest sub-array with sum - when multiple such sub-arrays exist with same lengths`() {
    assertEquals(2, SmallestSubArrayWithSum.findLength_naive(intArrayOf(3, 4, 1, 1, 6), 7))
  }

  @Test
  fun `smallest sub-array with sum - when multiple such sub-arrays exist with different lengths`() {
    assertEquals(2, SmallestSubArrayWithSum.findLength_naive(intArrayOf(3, 4, 1, 2, 6), 8))
  }

  /* Improved way - single sliding window */
  @Test
  fun `smallest sub-array with sum (improved) - empty array should behave as when it does not exist (returns 0)`() {
    assertEquals(0, SmallestSubArrayWithSum.findLength_slidingWindow(intArrayOf(), 5))
  }

  @Test
  fun `smallest sub-array with sum (improved) - when sum does not exist return 0`() {
    assertEquals(0, SmallestSubArrayWithSum.findLength_slidingWindow(intArrayOf(2, 4, 6, 8), 11))
  }

  @Test
  fun `smallest sub-array with sum (improved) - when single such sub-array exists`() {
    assertEquals(2, SmallestSubArrayWithSum.findLength_slidingWindow(intArrayOf(2, 4, 6, 8), 10))
  }

  @Test
  fun `smallest sub-array with sum (improved) - when multiple such sub-arrays exist with same lengths`() {
    assertEquals(2, SmallestSubArrayWithSum.findLength_slidingWindow(intArrayOf(3, 4, 1, 1, 6), 7))
  }

  @Test
  fun `smallest sub-array with sum (improved) - when multiple such sub-arrays exist with different lengths`() {
    assertEquals(2, SmallestSubArrayWithSum.findLength_slidingWindow(intArrayOf(3, 4, 1, 2, 6), 8))
  }

  /* Comparing the naive and non-naive on large input */
  @Test
  fun `smallest sub-array - comparing the performance of naive vs improved`() {
    val array = IntArray(1_000_000) { Random.nextInt() % 50 }

    val naiveTime = measureTimeMillis { SmallestSubArrayWithSum.findLength_naive(array, 1000) }
    val improvedTime = measureTimeMillis { SmallestSubArrayWithSum.findLength_slidingWindow(array, 1000) }

    assertTrue(naiveTime > improvedTime)
    println("Naive: $naiveTime, Improved: $improvedTime") // Naive: 5453ms, Improved: 4ms
  }
}