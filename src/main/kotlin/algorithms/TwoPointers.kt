package dev.janku.learning.algorithms

/**
 * The two-pointers technique
 *
 * Using two pointers to solve problems regarding
 * - typically in sorted arrays/lists to find a sub-list with the given constraints
 * - there are 2 typical scenarios:
 *   a) opposite direction - one pointer at the beginning and the other at the end (f.e. palindrome checking)
 *   b) same direction - fast/slow pointers aka "Hare and Tortoise algorithm" (f.e. cycle detection)
 */
object TwoPointers {

  /** Check if the given string is a palindrome - time O(N), space O(1) */
  fun isPalindrome(str: String): Boolean {
    var startPtr = 0
    var endPtr = str.length - 1

    while (startPtr < endPtr) {
      if (str[startPtr] != str[endPtr]) return false
      startPtr++
      endPtr--
    }
    return true
  }

  /** A naive approach to compare performance - O(N), space O(N) */
  fun isPalindrome_naive(str: String): Boolean {
    return str == str.reversed()
  }

  /**
   * Check if the given list has a cycle
   * - using the "Hare and Tortoise algorithm" - time O(N), space O(1)
   * @param head - head of the list
   * @return true if there is a cycle, false otherwise
   *
   * The slow pointer moves +1, the fast pointer moves +2, which in case of cycle can result in 2 scenarios:
   * a) slow pointer is 1 step ahead of the fast pointer, which means the fast pointer will catch up in the next step
   * b) slow pointer is 2 steps ahead of the fast pointer, so the next step will result in situation a)
   *
   * If there is no cycle, the fast pointer will reach the end of the list.
   * Otherwise, the slow pointer will eventually meet the fast pointer.
   */
  fun isCycle(head: ListNode<Int>) : Boolean {
    var slowPtr : ListNode<Int>? = head
    var fastPtr : ListNode<Int>? = head

    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next?.next
      slowPtr = slowPtr!!.next

      if (slowPtr == fastPtr) return true
    }

    return false
  }
}