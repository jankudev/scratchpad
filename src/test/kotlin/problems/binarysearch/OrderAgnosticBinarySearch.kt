package problems.binarysearch

import dev.janku.learning.problems.binarysearch.OrderAgnosticBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderAgnosticBinarySearch {
  @Test
  fun `empty array`() {
    val array = emptyArray<Int>()
    assertEquals(-1, OrderAgnosticBinarySearch.orderAgnosticBinSearchForElement(array, 1))
  }

  @Test
  fun `not found - single elemenet array (can't determine ordering)`() {
    val array = arrayOf(1)
    assertEquals(-1, OrderAgnosticBinarySearch.orderAgnosticBinSearchForElement(array, 2))
  }

  @Test
  fun `found - single elemenet array (can't determine ordering)`() {
    val array = arrayOf(1)
    assertEquals(0, OrderAgnosticBinarySearch.orderAgnosticBinSearchForElement(array, 1))
  }

  @Test
  fun `found - larger array ascending`() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
    assertEquals(4, OrderAgnosticBinarySearch.orderAgnosticBinSearchForElement(array, 5))
  }

  @Test
  fun `not found - larger array ascending`() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
    assertEquals(-1, OrderAgnosticBinarySearch.orderAgnosticBinSearchForElement(array, 10))
  }

  @Test
  fun `found - larger arrray descending`() {
    val array = arrayOf(7, 6, 5, 4, 3, 2, 1)
    assertEquals(2, OrderAgnosticBinarySearch.orderAgnosticBinSearchForElement(array, 5))
  }

  @Test
  fun `not found - larger arrray descending`() {
    val array = arrayOf(7, 6, 5, 4, 3, 2, 1)
    assertEquals(-1, OrderAgnosticBinarySearch.orderAgnosticBinSearchForElement(array, 10))
  }
}