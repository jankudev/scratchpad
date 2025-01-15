package basics

import dev.janku.learning.basics.Queue
import dev.janku.learning.basics.Stack
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LearningStackQueuesTest {

  @Test
  fun `stack - testing basic operations`() {
    val stack = Stack<Int>()

    // new stack
    assertTrue(stack.isEmpty())
    assertEquals(0, stack.size())

    // first element
    stack.push(1)
    assertEquals(1, stack.size())
    assertEquals(1, stack.peek())

    // removing from stack
    val element = stack.pop()
    assertEquals(1, element)
    assertTrue(stack.isEmpty())

    // adding more elements to stack
    stack.push(2)
    stack.push(3)
    stack.push(4)
    assertEquals(3, stack.size())
    assertEquals(4, stack.peek())

    val removedTop = stack.pop()
    assertEquals(4, removedTop)
    assertEquals(2, stack.size())
    assertEquals(3, stack.peek())
  }

  @Test
  fun `queue - testing basic operations`() {
    val queue = Queue<Int>()

    // new queue
    assertTrue(queue.isEmpty())
    assertEquals(0, queue.size())

    // first element
    queue.enqueue(1)
    assertEquals(1, queue.size())
    assertEquals(1, queue.peek())

    // removing from queue
    val element = queue.dequeue()
    assertEquals(1, element)
    assertTrue(queue.isEmpty())

    // adding more elements to queue
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    assertEquals(3, queue.size())
    assertEquals(2, queue.peek())

    val removedTop = queue.dequeue()
    assertEquals(2, removedTop)
    assertEquals(2, queue.size())
    assertEquals(3, queue.peek())
  }
}