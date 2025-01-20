package problems.linkedList

import dev.janku.learning.algorithms.ListNode
import dev.janku.learning.problems.linkedList.LinkedListReversal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNull

class LinkedListReversalTest {

  companion object {
    fun <T>listOfValuesOfLinkedList(head: ListNode<T>) : List<T> {
      val result = mutableListOf<T>()
      var current: ListNode<T>? = head
      while (current != null) {
        result.add(current.value)
        current = current.next
      }
      return result
    }

    fun <T>createLinkedList(list: List<T>) : ListNode<T>? {
      if (list.isEmpty()) return null
      val head = ListNode(list[0])
      var current = head
      for (i in 1 until list.size) {
        current.next = ListNode(list[i])
        current = current.next!!
      }
      return head
    }
  }

  @Test
  fun `linked list - reversal - single node`() {
    val list = ListNode(1)
    assertEquals(list, LinkedListReversal.reverse(list))
    assertNull(list.next)
  }

  @Test
  fun `linked list - reversal - multiple nodes`() {
    val list = ListNode(1, ListNode(2, ListNode(3)))
    val reversed = LinkedListReversal.reverse(list)

    assertEquals(listOf(3, 2, 1), listOfValuesOfLinkedList(reversed))
  }

  /* Partial reversal */
  @Test
  fun `linked list - partial reversal - list with no reversal`() {
    val llist = createLinkedList(listOf(1, 2, 3, 4, 5))
    val reversed_badPositions = LinkedListReversal.reverseSubList(llist!!, Pair(5,5))
    val reversed_outOfBoundsPositions = LinkedListReversal.reverseSubList(llist!!, Pair(10,15))

    assertEquals(listOf(1, 2, 3, 4, 5), listOfValuesOfLinkedList(reversed_badPositions))
    assertEquals(listOf(1, 2, 3, 4, 5), listOfValuesOfLinkedList(reversed_outOfBoundsPositions))
  }

  @Test
  fun `linked list - partial reversal - list with full reversal`() {
    val llist = createLinkedList(listOf(1, 2, 3, 4, 5))
    val reversed = LinkedListReversal.reverseSubList(llist!!, Pair(1,5))
    assertEquals(listOf(5, 4, 3, 2, 1), listOfValuesOfLinkedList(reversed))
  }

  @Test
  fun `linked list - partial reversal - list with reversal at beginning`() {
    val llist = createLinkedList(listOf(1, 2, 3, 4, 5))
    val reversed = LinkedListReversal.reverseSubList(llist!!, Pair(1,2))
    assertEquals(listOf(2, 1, 3, 4, 5), listOfValuesOfLinkedList(reversed))
  }

  @Test
  fun `linked list - partial reversal - list with reversal at end`() {
    val llist = createLinkedList(listOf(1, 2, 3, 4, 5))
    val reversed = LinkedListReversal.reverseSubList(llist!!, Pair(4,5))
    assertEquals(listOf(1, 2, 3, 5, 4), listOfValuesOfLinkedList(reversed))
  }

  @Test
  fun `linked list - partial reversal - list with reversal at end with out of bounds`() {
    val llist = createLinkedList(listOf(1, 2, 3, 4, 5))
    val reversed = LinkedListReversal.reverseSubList(llist!!, Pair(4,10))
    assertEquals(listOf(1, 2, 3, 5, 4), listOfValuesOfLinkedList(reversed))
  }

  @Test
  fun `linked list - partial reversal - list with reversal in the middle`() {
    val llist = createLinkedList(listOf(1, 2, 3, 4, 5))
    val reversed = LinkedListReversal.reverseSubList(llist!!, Pair(2,4))
    assertEquals(listOf(1, 4, 3, 2, 5), listOfValuesOfLinkedList(reversed))
  }
}