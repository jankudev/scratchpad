package dev.janku.learning.problems.binarysearch

/**
 * Order Agnostic Binary Search
 * - array sorted but ascending or descending
 * - function to search for an element in the array
 */
class OrderAgnosticBinarySearch {
  companion object {

    /** Constant for not found element (pattern: Value Object) */
    const val NOT_FOUND = -1

    /**
     * Search for an element no matter how the array is sorted (ascending or descending)
     * @param array - sorted array of elements
     * @param element - element to search for of the same type
     * @return index of the element in the array or NOT_FOUND if not found
     */
    fun <T : Comparable<T>> orderAgnosticBinSearchForElement(array: Array<T>, element: T): Int {

      // guard clauses for edge cases
      if (array.isEmpty()) {
        return NOT_FOUND
      }
      if (array.size == 1) {
        return if (array[0].equals(element)) 0 else NOT_FOUND
      }

      // determine sorting
      val isAscending = array[0] <= array[array.size - 1]

      // 2 pointer approach to binary search
      var leftIdx = 0
      var rightIdx = array.size - 1

      while (leftIdx <= rightIdx) {
        val midIdx = leftIdx + (rightIdx - leftIdx) / 2
        val midElement = array[midIdx]

        if (midElement.equals(element)) return leftIdx

        when (isAscending) {
          // ascending
          true -> {
            if (midElement < element) {
              leftIdx = midIdx + 1
            } else {
              rightIdx = midIdx - 1
            }
          }
          // descending
          false -> {
            if (midElement > element) {
              leftIdx = midIdx + 1
            } else {
              rightIdx = midIdx - 1
            }
          }
        }
      }

      return NOT_FOUND
    }
  }
}