package dev.janku.learning.basics

/**
 * Stack (LIFO) and Queue (FIFO)
 * - use ArrayDeque for both as it's the recommended approach
 * - alternatively list or array can be used
 *
 * Standard Stack operations:
 *  -> push = add(element) - adds to the end
 *  -> pop = removeLast() or removeLastOrNull() - removes from the end
 *  -> peek = last() or lastOrNull() - returns last element without removing
 *  -> size = size - attribute of collection
 *  -> empty = isEmpty() - check emptiness
 *
 * Standard Queue operations:
 *  -> enqueue = add(element) or addLast(element) - adds to the end
 *  -> dequeue = removeFirst() or removeFirstOrNull() - removes from the beginning
 *  -> peek = first() or fistOrNull() - returns first element without removing
 */
class Stack<T> (private val stack: ArrayDeque<T> = ArrayDeque()) {
  fun push(element: T) = stack.add(element)
  fun pop(): T? = stack.removeLastOrNull()
  fun peek(): T? = stack.lastOrNull()
  fun size(): Int = stack.size
  fun isEmpty(): Boolean = stack.isEmpty()
}

class Queue<T> (private val queue: ArrayDeque<T> = ArrayDeque()) {
  fun enqueue(element: T) = queue.add(element)
  fun dequeue(): T? = queue.removeFirstOrNull()
  fun peek(): T? = queue.firstOrNull()
  fun size(): Int = queue.size
  fun isEmpty(): Boolean = queue.isEmpty()
}