package dev.janku.learning.basics

/**
 * Learning about arrays in Kotlin.
 * - default structure is List (not fixed size), but Array is fixed size
 * - arrays default mutable, lists default immutable
 */
class LearningArrays {

  fun basicsOfArrays() {
    val typeInferredArray = arrayOf(1, 2, 3)                 // [1, 2, 3] (Array<Int>)
    val zeroedArrayOfSize = IntArray(5)                 // [0, 0, 0, 0, 0]
    val arrayOfStringNulls = arrayOfNulls<String>(5)    // [null, null, null, null, null]
  }

  fun lambdaGeneratedArrays() {
    val indexGeneratedArray = Array(5) { i -> i * i }   // [0, 1, 4, 9, 16]
    val evenNumbers = Array(10) { it * 2 }              // [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
    val oddNumbers = Array(10) { it * 2 + 1 }           // [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
    val alphabetGenArray =
      Array(26) { idx -> 'A' + idx }                    // [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
  }

  fun typedArrays() {
    val intArray = intArrayOf(1, 2, 3)                       // [1, 2, 3]
    val doubleArray = doubleArrayOf(1.1, 2.2, 3.3)           // [1.1, 2.2, 3.3]
    val charArray = charArrayOf('a', 'b', 'c')               // [a, b, c]
  }

  fun basicArrayOperations() {
    val array = arrayOf(1, 2, 3, 4, 5)

    val firstElement = array[0]
    val lastElement = array.last()
    val arraySize = array.size
  }

  fun modifyingArrayOperations() {
    val array = arrayOf(1, 2, 3, 4, 5)

    array[0] = 10
    array.sort()
    array.fill(0)
  }

  fun iteratingOverArray() {
    val array = arrayOf(1, 2, 3, 4, 5)

    for (element in array) {
      println(element)
    }

    for ((element, index) in array.withIndex()) {
      println("Element $element is at index $index")
    }
  }

  fun commonArrayMethos() {
    val numbers = arrayOf(1, 2, 3, 4, 5)

    // math methods
    val sum = numbers.sum()
    val average = numbers.average()
    val max = numbers.max()
    val min = numbers.min()

    // searching
    val contains5 = numbers.contains(5)
    val indexOf5 = numbers.indexOf(5)

    // sub-arrays and modified array copies
    val subArray = numbers.slice(0..2)
    val reversedArray = numbers.reversedArray()
    val sortedArray = numbers.sorted()
    val distinctElementsOnly = numbers.distinct()
  }

  fun transformingArraysFunctionally() {
    val numbers = arrayOf(1, 2, 3, 4, 5)

    // map
    val squaredNumbers = numbers.map { it * it }.toTypedArray()     // without typing returns List

    // filter
    val oddNumbers = numbers.filter { it % 2 != 0 }.toTypedArray()  // without typing returns List

    // combining in functional way
    val squaredOddReversedNumbers =
      numbers.filter { it % 2 != 0 }
        .map { it * it }
        .sorted()
        .reversed()
        .toTypedArray()
  }

  fun multidimensionalArrays() {
    val matrix = Array(3) { Array(3) { 0 } }    // 3x3 matrix filled with zeros

    // accessing and modifying [row][column]
    matrix[0][0] = 1
    var middleElement = matrix[1][1]

    // iterating over array
    for (row in matrix) {
      for (element in row) {
        println(element)
      }
    }
  }


  /* --------- *//* Fibonacci *//* --------- */
  fun genArrayFibonacciUsingSequence(size: Int): IntArray {
    if (size <= 0) {
      return intArrayOf()
    }

    return generateSequence(Pair(1, 1)) { Pair(it.second, it.first + it.second) }
      .map { it.first }
      .take(size)
      .toList()
      .toIntArray()
  }

  fun fibonacciUsingCycle(size: Int): IntArray {
    if (size <= 0) return intArrayOf()
    if (size == 1) return intArrayOf(1)
    if (size == 2) return intArrayOf(1, 1)

    val fibonacci = IntArray(size).toMutableList()
    fibonacci[0] = 1
    fibonacci[1] = 1

    for (i in 2 until size) {
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
    }

    return fibonacci.toIntArray()
  }
}