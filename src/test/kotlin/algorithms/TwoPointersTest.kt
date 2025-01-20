package algorithms

import dev.janku.learning.algorithms.ListNode
import dev.janku.learning.algorithms.TwoPointers
import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TwoPointersTest {
  /* Palindrome */
  @Test
  fun `palindrome - empty string`() {
    assertTrue(TwoPointers.isPalindrome(""))
  }

  @Test
  fun `palindrome - single letter string`() {
    assertTrue(TwoPointers.isPalindrome("a"))
  }

  @Test
  fun `palindrome - two same characters are palindrome`() {
    assertTrue(TwoPointers.isPalindrome("aa"))
  }

  @Test
  fun `palindrome - two distinct characters are not palindrome`() {
    assertFalse(TwoPointers.isPalindrome("ab"))
  }

  @Test
  fun `palindrome - same word in both directions is palindrome`() {
    assertTrue(TwoPointers.isPalindrome("abba"))
    assertTrue(TwoPointers.isPalindrome("level"))
  }

  @Test
  fun `palindrome - same word 2 times following is not a palinrome`() {
    assertFalse(TwoPointers.isPalindrome("dodo"))
  }

  @Test
  fun `palindrome - complexity comparison of 2-pointer vs naive reversal+equals`() {
    val str = "a".repeat(100_000_000)
    val time = measureNanoTime { TwoPointers.isPalindrome(str) }
    val timeNaive = measureNanoTime { TwoPointers.isPalindrome_naive(str) }
    assertTrue(time < timeNaive)
    println("Time for 2-pointer: ${time}ns, time for naive: ${timeNaive}ns") // difference almost insignificant as both are O(n)
  }


  /* Cycle detection */
  fun `cycle detection - single element list - 1`() {
    assertFalse(TwoPointers.isCycle(ListNode(1)))
  }

  @Test
  fun `cycle detection - linked list without cycle 1-2-3-4`() {
    assertFalse(TwoPointers.isCycle(ListNode(1, ListNode(2, ListNode(3, ListNode(4))))))
  }

  @Test
  fun `cycle detection - linked list with cycle of odd size 1-2-3-4-2`() {
    val node4 = ListNode(4)
    val node3 = ListNode(3, node4)
    val node2 = ListNode(2, node3)
    val node1 = ListNode(1, node2)
    node4.next = node2

    assertTrue(TwoPointers.isCycle(node1))
  }

  @Test
  fun `cycle detection - linked list with cycle of even size 1-2-3-2`() {
    val node3 = ListNode(3)
    val node2 = ListNode(2, node3)
    val node1 = ListNode(1, node2)
    node3.next = node2

    assertTrue(TwoPointers.isCycle(node1))
  }

}