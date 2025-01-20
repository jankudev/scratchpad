package problems.intervals

import dev.janku.learning.problems.intervals.Intervals
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntervalsTest {
  /* Intersection finding */
  @Test
  fun `intersection - empty interval lists - empty result`() {
    val intersections = Intervals.findIntersections(emptyList(), emptyList())
    assertTrue(intersections.isEmpty())
  }

  @Test
  fun `intersection - one empty interval list - empty result`() {
    val intersections = Intervals.findIntersections(emptyList(), listOf(1 to 2, 3 to 4))
    val intersections2 = Intervals.findIntersections(listOf(1 to 2, 3 to 4), emptyList())
    assertTrue(intersections.isEmpty())
    assertTrue(intersections2.isEmpty())
  }

  @Test
  fun `intersection - no intersections`() {
    val intersections = Intervals.findIntersections(
      listOf(1 to 2, 3 to 4, 5 to 6),
      listOf(7 to 8, 9 to 10, 11 to 12)
    )
    assertTrue(intersections.isEmpty())
  }

  @Test
  fun `intersection - intervals the same - single intersection`() {
    val intersections = Intervals.findIntersections(
      listOf(1 to 10),
      listOf(1 to 10)
    )
    assertContentEquals(listOf(1 to 10), intersections)
  }

  @Test
  fun `intersections - one interval is sub-interval of another`() {
    val intersections = Intervals.findIntersections(
      listOf(1 to 10),
      listOf(3 to 5)
    )
    assertContentEquals(listOf(3 to 5), intersections)
  }

  @Test
  fun `intersections - intervals overlap`() {
    val intersections = Intervals.findIntersections(
      listOf(1 to 5),
      listOf(3 to 10)
    )
    assertContentEquals(listOf(3 to 5), intersections)
  }

  @Test
  fun `intersections - multiple intersections`() {
    val intersections = Intervals.findIntersections(
      listOf(1 to 5, 7 to 10, 12 to 15),
      listOf(3 to 8, 9 to 12)
    )
    assertContentEquals(listOf(3 to 5, 7 to 8, 9 to 10, 12 to 12), intersections)
  }

  /* Merging intervals into a list of disjoint intervals */
  @Test
  fun `merge - empty list - empty result`() {
    val merged = Intervals.merge(emptyList())
    assertTrue(merged.isEmpty())
  }

  @Test
  fun `merge - single interval - the same interval`() {
    val merged = Intervals.merge(listOf(1 to 10))
    assertContentEquals(listOf(1 to 10), merged)
  }

  @Test
  fun `merge - no overlapping intervals and no same boundary - the same list`() {
    val merged = Intervals.merge(listOf(1 to 5, 7 to 10, 12 to 15))
    assertContentEquals(listOf(1 to 5, 7 to 10, 12 to 15), merged)
  }

  @Test
  fun `merge - no overlapping intervals, same boundary - joined interval`() {
    val merged = Intervals.merge(listOf(1 to 5, 5 to 10))
    assertContentEquals(listOf(1 to 10), merged)
  }

  @Test
  fun `merge - overlapping intervals - merged intervals`() {
    val merged = Intervals.merge(listOf(1 to 5, 3 to 10))
    assertContentEquals(listOf(1 to 10), merged)
  }

  @Test
  fun `merge - overlapping intervals - multiple merged intervals`() {
    val merged = Intervals.merge(listOf(1 to 5, 3 to 10, 12 to 15, 14 to 20))
    assertContentEquals(listOf(1 to 10, 12 to 20), merged)
  }

  @Test
  fun `merge - overlapping intervals - unsorted`() {
    val merged = Intervals.merge(listOf(14 to 20, 12 to 15, 3 to 10, 1 to 5))
    assertContentEquals(listOf(1 to 10, 12 to 20), merged)
  }

  /* Finding if overlap exists */
  @Test
  fun `exists overlap - empty list - false`() {
    val result = Intervals.existsOverlap(emptyList())
    assertFalse(result)
  }

  @Test
  fun `exists overlap - single item list - false`() {
    val result = Intervals.existsOverlap(listOf(1 to 10))
    assertFalse(result)
  }

  @Test
  fun `exists overlap - no overlap`() {
    val result = Intervals.existsOverlap(listOf(1 to 5, 7 to 10))
    assertFalse(result)
  }

  @Test
  fun `exists overlap - single overlap`() {
    val result = Intervals.existsOverlap(listOf(1 to 5, 3 to 10))
    assertTrue(result)
  }

  @Test
  fun `exists overlap - example 1 - single overlap in multiple intervals`() {
    val result = Intervals.existsOverlap(listOf(1 to 4, 2 to 5, 7 to 8))
    assertTrue(result)
  }

  @Test
  fun `exists overlap - example 2 (unsorted) - no overlapping intervals`() {
    val result = Intervals.existsOverlap(listOf(6 to 7, 2 to 4, 8 to 12))
    assertFalse(result)
  }

  @Test
  fun `exists overlap - example 3 (unsorted) - overlapping intervals`() {
    val result = Intervals.existsOverlap(listOf(4 to 5, 2 to 4, 3 to 6))
    assertTrue(result)
  }
}