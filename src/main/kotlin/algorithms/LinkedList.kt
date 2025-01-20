package dev.janku.learning.algorithms

/** Implementation of a traditional linked list */
data class ListNode<T>(
  val value: T,
  var next: ListNode<T>? = null
)

/** Implementation of a bidirectional linked list */
data class BidirectionalListNode<T>(
  val value: T,
  var next: BidirectionalListNode<T>? = null,
  var prev: BidirectionalListNode<T>? = null
)