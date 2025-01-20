package dev.janku.learning.problems.linkedList

import dev.janku.learning.algorithms.ListNode

/** Problem solutions regarding reversing linked lists - common LeetCode assignment (in-place) */
object LinkedListReversal {

  /**
   * In-place reversal of the given linked list
   * @param T - type of the linked list content (node value)
   * @param head - head of the linked list
   * @return new head of the reversed linked list
   */
  fun <T> reverse(head: ListNode<T>) : ListNode<T> {

    var prev : ListNode<T>? = null
    var current : ListNode<T>? = head

    while (current != null) {
      val next = current.next
      current.next = prev
      prev = current
      current = next
    }

    return prev!!
  }

  /**
   * Partial reversal of a linked list - reverse the sublist from position 'a' to 'b'
   * @param T - type of the linked list content (node value)
   * @param head - head of the linked list
   * @param subListPositions - pair of positions 'a' and 'b' to reverse the sublist
   */
  fun <T> reverseSubList(head: ListNode<T>, subListPositions: Pair<Int, Int>) : ListNode<T> {
    require(subListPositions.first <= subListPositions.second) { "Invalid sublist positions" }
    require(subListPositions.first > 0) { "Invalid sublist positions" }
    require(subListPositions.second > 0) { "Invalid sublist positions" }

    val from = subListPositions.first
    val to = subListPositions.second   // inclusive, can be after the end of the list as we have no knowledge of size

    // guard - no reversal needed
    if (from == to) return head

    var current : ListNode<T>? = head
    var prev : ListNode<T>? = null

    // copy the initial part of the list until the 'from' position
    for (i in 1 until from) {
      if (current?.next == null) return head
      prev = current
      current = current.next
    }

    // remember the last node of the first part and the first node of the sublist
    val lastNodeOfFirstPart = prev
    val lastNodeOfSublist = current

    // reverse the sublist
    var itemsToReverse = to - from + 1
    while (itemsToReverse > 0 && current != null) {
      val next = current.next
      current.next = prev
      prev = current
      current = next
      itemsToReverse--
    }

    // connect the first part with the reversed sublist, but if the first part is null, the new head is the last sublist element processed
    var newHead : ListNode<T>? = head
    if (lastNodeOfFirstPart != null) {
      lastNodeOfFirstPart.next = prev
    } else {
      newHead = prev
    }

    // connect the last sublist element with the rest of the list
    lastNodeOfSublist?.next = current

    return newHead!!
  }
}