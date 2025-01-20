package dev.janku.learning.problems.sets

object SetsAndPermutations {
  /**
   * Given a list of distinct numbers, generate all possible distinct subsets (the power set).
   * @param nums - list of distinct numbers
   * @return list of all possible subsets
   *
   * hint: BFS-like algorithm, start with an empty set, process all numbers and for each add it to all existing sets
   * [[]] -> [[], [1]] -> [[], [1], [2], [1,2]] -> [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
   *
   * Time complexity: O(2^N) where N is the size of the input list - with each step we double the number of sub-sets
   */
  fun subsets(nums: List<Int>): List<List<Int>> {
    val result = mutableListOf<List<Int>>(emptyList())

    for (num in nums) {
      // processing by idx to avoid ConcurrentModificationException
      for (setIdx in 0 until result.size) {
        result.add(result[setIdx] + num)
      }
    }

    return result
  }

  /**
   * Given a list of distinct numbers find all possible permutations.
   * @param nums - list of distinct numbers
   * @return list of all possible permutations
   */
  fun permutations(nums: List<Int>): List<List<Int>> {
    TODO()
  }
}