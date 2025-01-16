package dev.janku.learning.algorithms

/**
 * Binary search algorithm
 * - requires collection to be sorted
 * - avoid recursion
 *
 * Time complexity: O(log n)
 * Space complexity: O(1) - if implemented without recursion, with pointers without in-middle sliced arrays, etc.
 */
class BinarySearch {

  companion object {
    const val NOT_FOUND = -1

    /**
     * Binary search in an sorted array
     * @param array - sorted array of elements
     * @param searchFor - element to search for of the same type
     * @return index of the element in the array or -1 if not found
     */
    fun <T : Comparable<T>> binarySearchArray(array: Array<T>, searchFor: T) : Int {

      // double pointer approach
      var leftIdx = 0
      var rightIdx = array.size - 1

      // iterate until both pointer aim at same position
      while (leftIdx <= rightIdx) {
        val middleIdx = leftIdx + (rightIdx - leftIdx) / 2
        val middleElement = array[middleIdx]

        if (middleElement.equals(searchFor)) {
          return middleIdx
        }

        if (middleElement < searchFor) {
          leftIdx = middleIdx + 1
        } else {
          rightIdx = middleIdx - 1
        }
      }

      return NOT_FOUND
    }
  }

}