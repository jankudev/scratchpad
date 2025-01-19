package dev.janku.learning.problems.slidingWindow

object LongestSubstringWithKDistinctChars {
  /**
   * Find the longest substring with K distinct characters
   * @param input - input string
   * @param numOfDistinctChars - number of distinct characters
   * @return longest substring with K distinct characters
   *
   * We will approach this problem using the sliding window pattern.
   * With the sliding window movement we will keep track of the number of distinct characters in the window and the number
   * of times they appear in the window.
   * When we move the window one step we decrease/remove the left letter, increase/add the right letter and we keep increasing
   * the window until we have more than K distinct characters.
   */
  fun find(input: String, numOfDistinctChars: Int) : String {
    if (input.isEmpty() || numOfDistinctChars == 0) return ""

    var windowStart = 0
    var maxLen = 0
    var maxLenWord = ""
    val windowLetterCounts = mutableMapOf<Char, Int>()

    for (windowEnd in 0 until input.length) {
      val charRight = input[windowEnd]
      windowLetterCounts[charRight] = windowLetterCounts.getOrDefault(charRight, 0) + 1

      // over K distinct characters
      while (windowLetterCounts.size > numOfDistinctChars) {
        val charLeft = input[windowStart]
        windowLetterCounts[charLeft] = windowLetterCounts[charLeft]!! - 1
        if (windowLetterCounts[charLeft] == 0) {
          windowLetterCounts.remove(charLeft)
        }
        windowStart++
      }

      if (maxLen < windowEnd - windowStart + 1) {
        maxLen = windowEnd - windowStart + 1
        maxLenWord = input.substring(windowStart, windowEnd + 1)
      }
    }

    return maxLenWord
  }
}