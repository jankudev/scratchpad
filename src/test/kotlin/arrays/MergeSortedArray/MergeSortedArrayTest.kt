package arrays.MergeSortedArray

import dev.janku.learning.arrays.MergeSortedArray.MergeSortedArray
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MergeSortedArrayTest {
    @Test
    fun example1() {
        val nums1 = arrayOf(1,2,3,0,0,0).toIntArray()
        val nums2 = arrayOf(2,5,6).toIntArray()

        assertContentEquals(arrayOf(1,2,2,3,5,6).toIntArray(), MergeSortedArray.merge2(nums1, 3, nums2, 3))
    }
}