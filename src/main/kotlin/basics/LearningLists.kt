package dev.janku.learning.basics

/**
 * Learning about lists in Kotlin.
 * - default immutable, must convert if requiring mutability
 * - dynamic size
 * - partitioning splits by predicate in 2 groups (Pair)
 * - grouping creates a map of lists based on key (Map)
 * - chunking and windowing allowed only on lists, not on arrays
 * - aggregation functional way
 *  a) reduce
 *    -> first element as accumulator initial value
 *    -> throws exception on empty list
 *    -> accumulator needs to be of the same type as items in the list
 *  b) fold
 *    -> set initial value of accumulator explicitly
 *    -> does not throw exception on empty list
 *    -> accumulator can be of different type than elements in the list
 */
class LearningLists {

  fun basicsOfLists() {
    val readOnlyList = listOf(1, 2, 3, 4, 5)            // modification throws compile error

    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    val convertedToMutableList = readOnlyList.toMutableList()
    mutableList[0] = 10
    convertedToMutableList.add(6)
  }

  fun creationOfLists() {
    val emptyList = emptyList<String>()
    val nullableList = listOf<String?>("a", null, "c")
    val nonNullableList = listOfNotNull(1, null, 2, null, 3) // [1, 2, 3]

    // mutable lists with size explicitly using Array as backing structure
    val arrayList = ArrayList<Int>()
    val initialSizeArrayList = ArrayList<Int>(10)
  }

  fun immutableListOperations() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // access
    val elementDirectAccess = numbers[3]
    val elementAtIndex = numbers.elementAt(3)
    val firstElement = numbers.first()
    val lastElement = numbers.last()

    // conditional access (predicate)
    val firstElementDivisibleBy3 = numbers.first { it % 3 == 0 }
  }

  fun mutableListOperations() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    // adding
    numbers.add(6)
    numbers.add(6, 7)   // insert at index
    numbers.addAll(listOf(8, 9, 10))  // adding all from another list

    // removing
    val removed = numbers.remove(3)         // remove element if in list, returns boolean
    val removedAt = numbers.removeAt(5)       // remove element at index
    val removeIf = numbers.removeIf { it % 2 == 0 } // remove even elements (based on predicate)
    numbers.clear()                                 // remove all elements
  }

  fun listTransformations() {
    val numbers = listOf(1, 2, 3, 4, 5)

    val doubled = numbers.map { it * 2 }
    val filteredEven = numbers.filter { it % 2 == 0 }
    val sorted = numbers.sorted()
    val reversed = numbers.reversed()

    // grouping and partitioning
    val oddAndEvenGrouped = numbers.groupBy { it % 2 } // will return a map: {0=[2, 4], 1=[1, 3, 5]}
    val oddAndEvenPartitioned =
      numbers.partition { it % 2 != 0 }  // first - list with true predicate, second - list with false predicate
  }

  fun chunking() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val chunks = numbers.chunked(2) // [[1, 2], [3, 4], [5, 6], [7, 8], [9]]
  }

  fun slidingWindow() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val windowed =
      numbers.windowed(3) // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9]]
  }

  fun aggregationFunctions() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // math methods (min, max are deprecated and replaced with minOrNull, maxOrNull)
    val sum = numbers.sum()
    val average = numbers.average()
    val max: Int? = numbers.maxOrNull()
    val maxNonNull: Int = numbers.maxOrNull() ?: Int.MAX_VALUE
    val min: Int? = numbers.minOrNull()
    val minNonNull: Int = numbers.minOrNull() ?: Int.MIN_VALUE

    // functional aggregation
    val product = numbers.reduce { acc, i -> acc * i }
    val sumSquares = numbers.fold(0) { acc, i -> acc + i * i }

    // strings joining
    val joined = numbers.joinToString() // default separator is ", "
    val joinedComplex = numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
  }

  fun listUtilityFunctions() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    // searching for element
    val isEmpty = numbers.isEmpty()
    val isNotEmpty = numbers.isNotEmpty()
    val contains3 = numbers.contains(3)
    val containsAll345 = numbers.containsAll(listOf(3, 4, 5))

    // find index of exact element
    val indexOf3 = numbers.indexOf(3)                   // -1 if not found
    val lastIndexOf3 = numbers.lastIndexOf(3)   // search from the back
    val indexOfFirstDoubleDigit = numbers.indexOfFirst { it >= 10 }

    // sub-lists
    val sublist = numbers.subList(1, 3)              // [2, 3]
    val subList2 = numbers.slice(1..3)  // [2, 3]

    // distinct elements
    val distinctElements = numbers.distinct()

    // grouping and partitioning
    val groupsByNumOfDigits =
      numbers.groupBy { it.toString().length }  // {1=[1, 2, 3, 4, 5, 6, 7, 8, 9], 2=[10, 11, 12, 13, 14, 15]}
    val partitionOddEven =
      numbers.partition { it % 2 != 0 }         // ([1, 3, 5, 7, 9, 11, 13, 15], [2, 4, 6, 8, 10, 12, 14])
  }
}