package algorithms

import dev.janku.learning.algorithms.SlidingWindow
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith

class SlidingWindowTest {
  /* Average of sub-arrays of size K */
  @Test
  fun `average of sub-arrays of size K - empty`() {
    val result = SlidingWindow.averageOfSubArraysOfSize(intArrayOf(), 3)
    val resultPtrs = SlidingWindow.averageOfSubArraysOfSizeWithPointers(intArrayOf(), 3)
    assert(result.isEmpty())
    assertContentEquals(result, resultPtrs)
  }

  @Test
  fun `average of sub-arrays of size K - smaller array than K`() {
    val result = SlidingWindow.averageOfSubArraysOfSize(intArrayOf(1, 2), 3)
    val resultPtrs = SlidingWindow.averageOfSubArraysOfSizeWithPointers(intArrayOf(1, 2), 3)
    assert(result.isEmpty())
    assertContentEquals(result, resultPtrs)
  }

  @Test
  fun `average of sub-arrays of size K - array of size K`() {
    val result = SlidingWindow.averageOfSubArraysOfSize(intArrayOf(1, 2, 3), 3)
    val resultPtrs = SlidingWindow.averageOfSubArraysOfSizeWithPointers(intArrayOf(1, 2, 3), 3)
    assertContentEquals(doubleArrayOf(2.0), result)
    assertContentEquals(result, resultPtrs)
  }

  @Test
  fun `average of sub-arrays of size K - larger example`() {
    val array = arrayOf(1, 3, 2, 6, -1, 4, 1, 8, 2).toIntArray()
    val expectedResult = arrayOf(2.2, 2.8, 2.4, 3.6, 2.8).toDoubleArray()

    val result = SlidingWindow.averageOfSubArraysOfSize(array, 5)
    val resultPtrs = SlidingWindow.averageOfSubArraysOfSizeWithPointers(array, 5)
    assertContentEquals(expectedResult, result)
    assertContentEquals(result, resultPtrs)
  }

  /* Max sum of sub-arrays of size K */
  @Test
  fun `max sum of sub-arrays of size K - empty`() {
    assertFailsWith<IllegalArgumentException> {
      SlidingWindow.maxSumOfSubArraysOfSize(intArrayOf(), 3)
    }
  }

  @Test
  fun `max sum of sub-arrays of size K - small size`() {
    assertFailsWith<IllegalArgumentException> {
      SlidingWindow.maxSumOfSubArraysOfSize(intArrayOf(1, 2), 3)
    }
  }

  @Test
  fun `max sum of sub-arrays of size K - array of size K`() {
    val result = SlidingWindow.maxSumOfSubArraysOfSize(intArrayOf(1, 2, 3), 3)
    assert(result == 6)
  }

  @Test
  fun `max sum of sub-arrays of size K - larger example`() {
    val array = arrayOf(2, 1, 5, 1, 3, 2).toIntArray()
    val result = SlidingWindow.maxSumOfSubArraysOfSize(array, 3)
    assert(result == 9)
  }
}