package dev.janku.learning.problems.cyclicSort

/**
 * Cyclic sort algorithm
 *
 * Problem: Sort an array of n distinct integers of sequence 1..n, but unsorted.
 * Constraint: O(1) space complexity - no additional data structures
 *
 * Naive solution O(n^2):
 * - For each number find the number, switch it with the number at the index of the number.
 *
 * Cyclic sort O(n):
 * - For each index we check the number at that index and cyclically swap it until the number is at the correct index.
 */
object InstancesSorter {

  /**
   * Sort the array of integers in-place using the cyclic sort algorithm
   * @param array - array of integers
   */
  fun sort(array: IntArray) {
    for (currentIdx in 0 until array.size) {
      val expectedNumberAtCurrentIdx = currentIdx + 1
      while (array[currentIdx] != expectedNumberAtCurrentIdx) {
        val currentNumber = array[currentIdx]
        val swapIdx = currentNumber - 1
        val swapValue = array[swapIdx]
        array[swapIdx] = currentNumber
        array[currentIdx] = swapValue
      }
    }
  }
}