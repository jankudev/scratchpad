package algorithms

import dev.janku.learning.algorithms.BinarySearch
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinarySearchTest {
  @Test
  fun `binary search array - empty array`() {
    val array = emptyArray<Int>()
    assertEquals(-1, BinarySearch.binarySearchArray(array, 1))
  }

  @Test
  fun `binary search array - not found`() {
    val array = arrayOf(1, 2, 3, 4, 5)
    assertEquals(-1, BinarySearch.binarySearchArray(array, 10))
  }

  @Test
  fun `binary search array - found`() {
    val array = arrayOf(1, 2, 3, 4, 5)
    assertEquals(2, BinarySearch.binarySearchArray(array, 3))
  }

  @Test
  fun `binary search array - very large input`() {
    val array = (1..10_000_000).toList().toTypedArray()
    assertEquals(5_000_000, BinarySearch.binarySearchArray(array, 5_000_001))
  }
}