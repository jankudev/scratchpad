package dev.janku.learning.algorithms

/**
 * Implementation of sorting algorithms in Kotlin (not modifying the original)
 * - merge sort
 */
class SortingAlgorithms {

  companion object {

    /* ---------- */
    /* Merge Sort */
    /* ---------- */
    private fun <T : Comparable<T>> merge(leftArray: Array<T>, rightArray: Array<T>): Array<T> {

      if (leftArray.isEmpty()) return rightArray
      if (rightArray.isEmpty()) return leftArray

      var leftArrayPtr = 0
      var rightArrayPtr = 0
      val resultArray = leftArray + rightArray
      var resultPtr = 0

      // merge the two arrays in ascending order
      while (leftArrayPtr < leftArray.size && rightArrayPtr < rightArray.size) {
        when {
          leftArray[leftArrayPtr] <= rightArray[rightArrayPtr] -> {
            resultArray[resultPtr] = leftArray[leftArrayPtr]
            resultPtr++
            leftArrayPtr++
          }

          else -> {
            resultArray[resultPtr] = rightArray[rightArrayPtr]
            resultPtr++
            rightArrayPtr++
          }
        }
      }

      // add the remaining elements of leftArray
      if (leftArrayPtr < leftArray.size) {
        for (i in leftArrayPtr until leftArray.size) {
          resultArray[resultPtr] = leftArray[i]
          resultPtr++
        }
      }

      // add the remaining elements of rightArray
      if (rightArrayPtr < rightArray.size) {
        for (i in rightArrayPtr until rightArray.size) {
          resultArray[resultPtr] = rightArray[i]
          resultPtr++
        }
      }

      return resultArray
    }

    /**
     * Merge sort implementation with complexity:
     * - time complexity: O(n log n)
     * - space complexity: O(n log n) due to recursion and copying arrays
     */
    fun <T : Comparable<T>> mergeSort(array: Array<T>): Array<T> {
      if (array.size <= 1) return array

      val middle = array.size / 2
      val leftArray = array.copyOfRange(0, middle)
      val rightArray = array.copyOfRange(middle, array.size)

      return merge(mergeSort(leftArray), mergeSort(rightArray))
    }
  }
}

/**
 * Implementation of sorting algorithms in Kotlin (in-ploce)
 * - merge sort
 */
class SortingAlgorithmsInPlace {
  companion object {
    /* ---------- */
    /* Merge Sort */
    /* ---------- */
    private fun <T: Comparable<T>> merge(array: Array<T>, startIdx: Int, midIdx: Int, endIdx: Int) {
      val tmpLeftArr = array.copyOfRange(startIdx, midIdx + 1)
      val tmpRightArr = array.copyOfRange(midIdx + 1, endIdx + 1)

      val leftArrSize = tmpLeftArr.size
      val rightArrSize = tmpRightArr.size

      var leftPtr = 0
      var rightPtr = 0
      var writingPtr = startIdx

      while (leftPtr < leftArrSize && rightPtr < rightArrSize) {
        when {
          tmpLeftArr[leftPtr] <= tmpRightArr[rightPtr] -> {
            array[writingPtr] = tmpLeftArr[leftPtr]
            leftPtr++
          }
          else -> {
            array[writingPtr] = tmpRightArr[rightPtr]
            rightPtr++
          }
        }
        writingPtr++
      }

      // copy rest of left
      while (leftPtr < leftArrSize) {
        array[writingPtr] = tmpLeftArr[leftPtr]
        leftPtr++
        writingPtr++
      }

      // copy rest of right
      while (rightPtr < rightArrSize) {
        array[writingPtr] = tmpRightArr[rightPtr]
        rightPtr++
        writingPtr++
      }
    }

    /**
     * Merge sort implementation with complexity:
     * - time complexity: O(n log n)
     * - space complexity: O(n) as even with the temporary arrays its at most O(2N)
     */
    fun <T : Comparable<T>> mergeSort(array: Array<T>, startIdx: Int = 0, endIdx: Int = array.size - 1) {
      // guard
      if (startIdx >= endIdx) return

      val midIdx = startIdx + (endIdx - startIdx) / 2
      mergeSort(array, startIdx, midIdx)
      mergeSort(array, midIdx + 1, endIdx)
      merge(array, startIdx, midIdx, endIdx)
    }
  }
}