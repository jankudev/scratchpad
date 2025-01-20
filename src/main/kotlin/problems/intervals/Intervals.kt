package dev.janku.learning.problems.intervals

object Intervals {
  /**
   * Problem: Given two lists of disjoint intervals both sorted ascending by interval start, find the intersection of these two lists.
   * @param list1 - first list of intervals
   * @param list2 - second list of intervals
   * @return list of intersecting intervals
   *
   * For each possible intersection there are 2 possible cases:
   * a) the list1(start) is within the list2 interval
   * b) the list2(start) is within the list1 interval
   * In such case the overlapping interval is max(list1(start), list2(start)) to min(list1(end), list2(end)).
   *
   * Time-complexity: O(N+M) where N and M are the sizes of the input lists
   */
  fun findIntersections(list1: List<Pair<Int, Int>>, list2: List<Pair<Int, Int>>) : List<Pair<Int, Int>> {
    if (list1.isEmpty() || list2.isEmpty()) return emptyList()

    val intersections = mutableListOf<Pair<Int, Int>>()

    var list1_idx = 0
    var list2_idx = 0

    while (list1_idx < list1.size && list2_idx < list2.size) {

      // start of current item in list1 is within the interval of the current item in list2
      val scenario_a = list1[list1_idx].first in list2[list2_idx].first..list2[list2_idx].second
      // start of current item in list2 is within the interval of the current item in list1
      val scenario_b = list2[list2_idx].first in list1[list1_idx].first..list1[list1_idx].second

      // intersection found, add it to the result
      if (scenario_a || scenario_b) {
        val start = maxOf(list1[list1_idx].first, list2[list2_idx].first)
        val end = minOf(list1[list1_idx].second, list2[list2_idx].second)
        intersections.add(start to end)
      }

      // move to the next interval based on the end of the current interval
      // (as they're disjoin in each list we iterate in the list where the current interval ends first)
      if (list1[list1_idx].second < list2[list2_idx].second) {
        list1_idx++
      } else {
        list2_idx++
      }
    }

    return intersections
  }

  /**
   * Given a lists of possibly overlapping intervals, merge them into a list of disjoint intervals.
   * @param list - list of intervals to merge
   * @return list of disjoint intervals
   *
   * Start by sorting the list by the start of the intervals.
   * Then iterating and if the start of next interval is within the current interval, merge them.
   */
  fun merge(list: List<Pair<Int,Int>>) : List<Pair<Int,Int>> {
    // guard - no overlap possible
    if (list.size <= 1) return list

    // sort
    val listSorted = list.sortedBy { it.first }

    val merged = mutableListOf<Pair<Int, Int>>()

    // start with the first interval and if overlapping extend it, if not start a new interval
    var intervalStart = listSorted[0].first
    var intervalEnd = listSorted[0].second

    for (interval in listSorted) {
      if (interval.first > intervalEnd) {
        merged.add(intervalStart to intervalEnd)
        intervalStart = interval.first
        intervalEnd = interval.second
      } else {
        intervalEnd = maxOf(intervalEnd, interval.second)
      }
    }
    // don't forget to add the last one
    merged.add(intervalStart to intervalEnd)

    return merged
  }

  /**
   * Given a list of intervals, check if there is an overlap. (aka "Conflicting appointments")
   * @param list - list of intervals
   * @return true if there is an overlap, false otherwise
   *
   * hint: Sort the intervals by startTime and check for overlaps
   */
  fun existsOverlap(list: List<Pair<Int, Int>>): Boolean {
    if (list.size <= 1) return false

    val listSorted = list.sortedBy { it.first }
    // overlap = start time of the next interval is before the end time of the current interval, return on first overlap
    for (idx in 1 until listSorted.size) {
      if (listSorted[idx].first < listSorted[idx-1].second) return true
    }
    return false
  }
}