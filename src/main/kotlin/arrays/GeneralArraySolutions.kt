package dev.janku.learning.arrays

class GeneralArraySolutions {
    companion object {
        /**
         * From the int array nums remove and count all the elements equal to 'val'
         * by moving them to the end of the array (replace them with the current last non-val element)
         *
         * @nums array of integers
         * @val integer value to remove
         * @return the number of val elements in the array (that had been moved)
         */
        fun removeElementInPlace(nums: IntArray, `val`: Int): Int {
            var i = 0
            var j = nums.size
            while (i < j) {
                if (nums[i] == `val`) {
                    nums[i] = nums[j - 1]
                    j--
                } else {
                    i++
                }
            }
            return j
        }

        /**
         * In-place removal of duplicates in array
         * @param nums array of integers, sorted in ascending order
         * @return number of unique elements
         */
        fun removeDuplicatesSortedArray(nums: IntArray): Int {
            if (nums.isEmpty()) {
                return 0
            }

            var j = 1

            for (i in 1 until nums.size) {
                if (nums[i] != nums[i - 1]) {
                    nums[j++] = nums[i]
                }
            }
            return j
        }

        /**
         * In-place removal of elements appearing more than twice in array
         * @param nums array of integers, sorted in ascending order
         * @return number of unique elements
         */
        fun removeDuplicatesSortedArrayII(nums: IntArray): Int {
            if (nums.size <= 2) {
                return nums.size
            }

            var j = 2

            for (i in 2 until nums.size) {
                if (nums[i] != nums[j - 1] || nums[i] != nums[j - 2]) {
                    nums[j++] = nums[i]
                }
            }
            return j
        }

        /**
         * Find the element that appears at least n/2 times in the array of length n
         */
        fun majorityElement(nums: IntArray): Int {
            return nums.groupBy { it }.maxBy { it.value.size }.key
        }
    }
}