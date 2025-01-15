package dev.janku.learning.basics

import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Learning about HashMap / HashSet in Kotlin.
 * - HashMap to store key-value pairs, HashSet to store unique elements
 * - constant time operations for add, remove, contains
 * - setOf/mapOf for immutable, hashSetOf/hashMapOf for mutable
 */
class LearningHashtables {

  fun basicHashSet() {
    val immutableSet = setOf(1, 2, 3, 4, 5)
    val set = hashSetOf(1, 2, 3, 4, 5)

    val isEmpty = set.isEmpty()
    val size = set.size

    // find
    val contains3 = set.contains(3)

    // union
    val setDoubleDigit = hashSetOf(10, 20, 30, 40, 50)
    val unionSet = set.union(setDoubleDigit)

    // difference
    val setEven = setOf(1, 3, 5)
    val oddSet = set.minus(setEven)

    // iterate over set
    for (element in set) {
      println(element)
    }
  }

  fun basicHashMap() {
    val immutableMap = mapOf(0 to "zero", 1 to "one", 2 to "two")
    val map = hashMapOf(0 to "zero", 1 to "one", 2 to "two")

    val isEmpty = map.isEmpty()
    val size = map.size

    // get value by key
    val containsKey2 = map.contains(2)            // or map.keys.contains(2) to find on list of keys
    val containsValue2 = map.containsValue("two") // or map.values.contains("two")
    val valueAsStr = map[2]

    // iterate over map
    for ((key, value) in map) {
      println("Key: $key, Value: $value")
    }
  }

  fun customHashMaps() {
    // initial capacity and load factor
    // FIXME: val hashMap = HashMap<String, Int>(initialCapacity = 10_000_000, loadFactor = 0.75f)
    // FIXME: type-aliased java collections don't allow for named parameters !!!
    val hashMap = HashMap<String, Int>(10_000_000, 0.75f)
    hashMap.clear()

    // thread-safe map
    val threadSafeMap = ConcurrentHashMap<String, Int>()
    val threadSafeMap2 = Collections.synchronizedMap(HashMap<String, Int>())
  }

  fun distinctCharactersInAString(input: String) : Set<Char> {
    // return input.toCharArray().toSet()
    // return input.toCharArray().distinct().toSet()

    val charSet = HashSet<Char>()
    for (char in input) {
      charSet.add(char)
    }
    return charSet
  }
}