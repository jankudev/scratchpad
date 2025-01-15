package basics

import dev.janku.learning.basics.LearningArrays
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class LearningArraysTest {

  private val fibonacciSequence7 = intArrayOf(1, 1, 2, 3, 5, 8, 13)

  /* Fibonacci - using functional */
  @Test
  fun `fibonacci - zero or negative N`() {
    val arraysUtil = LearningArrays()

    assertEquals(0, arraysUtil.genArrayFibonacciUsingSequence(0).size)
    assertEquals(0, arraysUtil.genArrayFibonacciUsingSequence(-1).size)
  }

  @Test
  fun `fibonacci - first`() {
    val arraysUtil = LearningArrays()

    assertContentEquals(intArrayOf(1), arraysUtil.genArrayFibonacciUsingSequence(1))
  }

  @Test
  fun `fibonacci - 7`() {
    val arraysUtil = LearningArrays()

    assertContentEquals(fibonacciSequence7, arraysUtil.genArrayFibonacciUsingSequence(7))
  }

  /* Fibonacci using alternative approaches */
  @Test
  fun `fibonacci - 7 - cycle`() {
    val arraysUtil = LearningArrays()

    assertContentEquals(intArrayOf(), arraysUtil.fibonacciUsingCycle(-1))
    assertContentEquals(intArrayOf(), arraysUtil.fibonacciUsingCycle(0))
    assertContentEquals(intArrayOf(1), arraysUtil.fibonacciUsingCycle(1))
    assertContentEquals(fibonacciSequence7, arraysUtil.fibonacciUsingCycle(7))
  }
}