package problems.cyclicSort

import dev.janku.learning.problems.cyclicSort.InstancesSorter
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class InstancesSorterTest {
  @Test
  fun `cyclic sort - empty array`() {
    val array = intArrayOf()
    InstancesSorter.sort(array)
    assert(array.isEmpty())
  }

  @Test
  fun `cyclic sort - single node array`() {
    val array = intArrayOf(1)
    InstancesSorter.sort(array)
    assert(array.contentEquals(intArrayOf(1)))
  }

  @Test
  fun `cyclic sort - sorted array`() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    InstancesSorter.sort(array)
    assert(array.contentEquals(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun `cyclic sort - single swap`() {
    val array = intArrayOf(2, 1, 3, 4, 5)
    InstancesSorter.sort(array)
    assert(array.contentEquals(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun `cyclic sort - full swap`() {
    val array = intArrayOf(5, 4, 3, 2, 1)
    InstancesSorter.sort(array)
    assert(array.contentEquals(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun `cyclic sort - large input, random order`() {
    val array = (1..1_000_000).shuffled().toIntArray()
    InstancesSorter.sort(array)
    assertContentEquals(array.sorted(), array.asList())
  }
}