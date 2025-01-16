package dev.janku.learning.problems.binarysearch

/**
 * Given a circular list of lowercase letters sorted in ascending order (a-z),
 * find the smallest letter in the given array greater than a given ‘key’.
 *
 * Example 1 - is in list:
 * Input: ['a', 'c', 'f', 'h'], key = 'f'
 * Output: 'h'
 *
 * Example 2 - is not in list:
 * Input: ['a', 'c', 'f', 'h'], key = 'b'
 * Output: 'c'
 *
 * Example 3 - is out of list:
 * Input: ['a', 'c', 'f', 'h'], key = 'm'
 * Output: 'a'
 *
 * Example 4 - is the end letter:
 * Input: ['a', 'c', 'f', 'h'], key = 'h'
 * Output: 'a'
 */
class NextLetterCircularList {

  companion object {

    fun nextLetterAfterKey(letters: Array<Char>, key: Char) : Char {

      // guard clause for empty list
      if (letters.isEmpty()) throw IllegalArgumentException("List of letters must not be empty - there is no possible next letter")

      // guard clause for boundaries - if key is before/after, then next is the first letter
      if (key < letters[0] || key >= letters[letters.size - 1]) return letters[0]

      // using binary search find closest
      var leftIdx = 0
      var rightIdx = letters.size - 1
      while (leftIdx <= rightIdx) {
        val midIdx = leftIdx + (rightIdx - leftIdx) / 2
        val midLetter = letters[midIdx]

        if (key >= midLetter) {
          leftIdx = midIdx + 1
        } else {
          rightIdx = midIdx - 1
        }
      }

      // we end with leftIdx pointing to the next letter after key as if it's key we +1
      return letters[leftIdx % letters.size]
    }

  }
}
