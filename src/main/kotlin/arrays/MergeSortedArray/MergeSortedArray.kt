package dev.janku.learning.arrays.MergeSortedArray

class MergeSortedArray {
    companion object {
        fun merge(nums1: IntArray, m: Int,  nums2: IntArray, n: Int) : IntArray {
            return nums1.take(m).plus(nums2.take(n)).sorted().toIntArray()
        }

        fun merge2(nums1: IntArray, m: Int,  nums2: IntArray, n: Int) : IntArray {
            var idx_n1 = 0
            var idx_n2 = 0
            var idx = 0

            val result = IntArray(m+n)

            while (idx < m+n) {
                if (idx_n1 < m && idx_n2 < n) {
                    if (nums1[idx_n1] < nums2[idx_n2]) {
                        result[idx] = nums1[idx_n1]
                        idx_n1++
                    } else {
                        result[idx] = nums2[idx_n2]
                        idx_n2++
                    }
                } else if (idx_n1 < m) {
                    result[idx] = nums1[idx_n1]
                    idx_n1++
                } else if (idx_n2 < n) {
                    result[idx] = nums2[idx_n2]
                    idx_n2++
                }
                idx++
            }

            return result
        }
    }
}
