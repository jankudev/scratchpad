package arrays

import dev.janku.learning.arrays.GeneralArraySolutions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GeneralArraySolutionsTest {
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
}