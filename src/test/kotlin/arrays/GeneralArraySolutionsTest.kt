package arrays

import dev.janku.learning.arrays.GeneralArraySolutions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class GeneralArraySolutionsTest {
    /* Remove element in place */
    @Test
    fun arrayRemoveElement_failedTest1() {
        val nums = intArrayOf(2)
        assertEquals(1, GeneralArraySolutions.removeElementInPlace(nums, 3))
    }

    @Test
    fun arrayRemoveElement_failedTest2() {
        val nums = intArrayOf()
        assertEquals(0, GeneralArraySolutions.removeElementInPlace(nums, 3))
    }

    @Test
    fun arrayRemoveElement_failedTest3() {
        val nums = intArrayOf(3,2,2,3)
        assertEquals(2, GeneralArraySolutions.removeElementInPlace(nums, 3))
    }

    /* Remove element in place II */
    @Test
    fun arrayRemoveElementII_failedTest1() {
        val nums = intArrayOf(1,1,1,2,2,3)
        val numDuplicates = GeneralArraySolutions.removeDuplicatesSortedArrayII(nums)
        assertAll({
            assertEquals(5, numDuplicates)
            assertContentEquals(intArrayOf(1,1,2,2,3), nums.take(5).toIntArray())
        })
    }

    @Test
    fun arrayRemoveElementII_failedTest2() {
        val nums = intArrayOf(0,0,1,1,1,1,2,3,3)
        val numDuplicates = GeneralArraySolutions.removeDuplicatesSortedArrayII(nums)
        assertAll(
            { assertEquals(7, numDuplicates) },
            { assertContentEquals(intArrayOf(0,0,1,1,2,3,3), nums.take(7).toIntArray()) }
        )
    }

    /* Maximum price in time series of stock prices*/
    @Test
    fun maxPrice_example1() {
        val prices = intArrayOf(7,1,5,3,6,4)
        assertEquals(5, GeneralArraySolutions.maxProfit(prices))
    }

    @Test
    fun maxPrice_example2() {
        val prices = intArrayOf(7,6,4,3,1)
        assertEquals(0, GeneralArraySolutions.maxProfit(prices))
    }

}
