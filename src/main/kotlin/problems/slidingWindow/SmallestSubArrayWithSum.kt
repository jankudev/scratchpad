package dev.janku.learning.problems.slidingWindow

object SmallestSubArrayWithSum {

  const val NOT_FOUND = 0

  /**
   * Find the length of the smallest sub-array in array of positive numbers of given sum
   * @param array - array of positive numbers
   * @param sum - expected sum
   * @return length of the smallest sub-array with the given sum
   *
   * Time complexity: O(n^3)
   * - we are trying N possible window sizes => O(n)
   * - for each such window size we are trying N - windowSize windows and summing them => O(n^2)
   */
  fun findLength_naive(array: IntArray, sum: Int): Int {
    if (array.isEmpty()) return NOT_FOUND

    for (size in 1..array.size) {
      array.toList().windowed(size, 1).any { it.sum() == sum }.let {
        if (it) return size
      }
    }
    return NOT_FOUND
  }

  /**
   * Find the length of the smallest sub-array in array of positive numbers of given sum
   * @param array - array of positive numbers
   * @param sum - expected sum
   * @return length of the smallest sub-array with the given sum
   *
   * Time complexity: O(n)
   * - we first find the window size starting from the beginning to get >= expected sum
   * - then we slide the window to the right and keep track of the minimum window size
   * - once reaching a sum we update the minimum window size
   */
  fun findLength_slidingWindow(array: IntArray, sum: Int): Int {
    if (array.isEmpty()) return NOT_FOUND

    var windowSum = 0
    var minLength : Int? = null
    var windowStart = 0

    // moves the window end to the right +1
    for (windowEnd in 0 until array.size) {
      windowSum += array[windowEnd]

      val windowSize = windowEnd - windowStart + 1
      if (windowSum == sum) {
        minLength = windowSize
      }

      // moves the window start to the right +1
      // (shrinking from the left until below the sum letting the for cycle to move the window end)
      while (windowSum >= sum && windowStart <= windowEnd) {
        windowSum -= array[windowStart]
        windowStart++
      }
    }

    return minLength ?: NOT_FOUND
  }
}