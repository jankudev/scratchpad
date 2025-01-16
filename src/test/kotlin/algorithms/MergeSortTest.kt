package algorithms

import dev.janku.learning.algorithms.SortingAlgorithms
import dev.janku.learning.algorithms.SortingAlgorithmsInPlace
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertContentEquals

class MergeSortTest {

  /* Not in-place variant */
  @Test
  fun `merge sort - empty array`() {
    val array = emptyArray<Int>()
    assertContentEquals(array, SortingAlgorithms.mergeSort(array))
  }

  @Test
  fun `merge sort - single element array`() {
    val array = arrayOf(1)
    assertContentEquals(array, SortingAlgorithms.mergeSort(array))
  }

  @Test
  fun `merge sort - large array`() {
    val array = (1..1_000_000).map { Random.nextInt() }.toTypedArray()
    assertContentEquals(array.sorted().toTypedArray(), SortingAlgorithms.mergeSort(array))
  }

  /* In-place variant */
  @Test
  fun `merge sort in-place - empty array`() {
    val array = emptyArray<Int>()
    SortingAlgorithmsInPlace.mergeSort(array)
    assertContentEquals(emptyArray(), array)
  }

  @Test
  fun `merge sort in-place- single element array`() {
    val array = arrayOf(1)
    SortingAlgorithmsInPlace.mergeSort(array)
    assertContentEquals(arrayOf(1), array)
  }

  @Test
  fun `merge sort in-place - large array`() {
    val array = (1..1_000_000).map { Random.nextInt() }.toTypedArray()
    val originalArray = array.copyOf().sorted().toTypedArray()
    SortingAlgorithmsInPlace.mergeSort(array)
    assertContentEquals(originalArray, array)
  }
}