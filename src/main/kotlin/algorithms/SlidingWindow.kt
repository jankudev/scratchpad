package dev.janku.learning.algorithms

/**
 * Sliding window pattern
 * - processing a array/list in a window of fixed size
 */
object SlidingWindow {
  /**
   * Calculate the average of all sub-arrays of size K
   * @param T - type of the array elements
   * @param array - array of elements
   * @param size - size of the subarray
   * @return array of averages
   */
  fun averageOfSubArraysOfSize(array: IntArray, size: Int) : DoubleArray {
    if (array.size < size) return doubleArrayOf()
    return array.toList().windowed(size, 1).map { it.average() }.toDoubleArray()
  }

  /** Calculate the average of all sub-arrays of size K using pointers */
  fun averageOfSubArraysOfSizeWithPointers(array: IntArray, size: Int) : DoubleArray {
    if (array.size < size) return doubleArrayOf()

    val resultArray = DoubleArray(array.size - size + 1)
    for (startIdx in 0 .. array.size - size) {
      var sum = 0
      for (i in startIdx until startIdx + size) {
        sum += array[i]
      }
      resultArray[startIdx] = sum.toDouble() / size
    }
    return resultArray
  }

  /**
   * Find the maximum sum of all sub-arrays of size K
   */
  fun maxSumOfSubArraysOfSize(array: IntArray, size: Int) : Int {
    if (array.size < size) throw IllegalArgumentException("Array is smaller than the subarray size")
    return array.toList().windowed(size, 1).map { it.sum() }.maxOrNull() ?: 0
  }
}