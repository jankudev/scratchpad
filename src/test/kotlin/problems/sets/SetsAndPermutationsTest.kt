package problems.sets

import dev.janku.learning.problems.sets.SetsAndPermutations
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SetsAndPermutationsTest {
  /* Subsets - distinct numbers */
  @Test
  fun `subsets - empty list`() {
    assertContentEquals(listOf(emptyList()), SetsAndPermutations.subsets(emptyList()))
  }

  @Test
  fun `subsets - single number`() {
    assertContentEquals(listOf(emptyList(), listOf(1)), SetsAndPermutations.subsets(listOf(1)))
  }

  @Test
  fun `subsets - 2 numbers`() {
    assertContentEquals(
      listOf(emptyList(), listOf(1), listOf(2), listOf(1,2)),
      SetsAndPermutations.subsets(listOf(1,2))
    )
  }

  @Test
  fun `subsets - 3 numbers`() {
    assertContentEquals(
      listOf(emptyList(), listOf(1), listOf(2), listOf(1,2), listOf(3), listOf(1,3), listOf(2,3), listOf(1,2,3)),
      SetsAndPermutations.subsets(listOf(1,2,3))
    )
  }
}