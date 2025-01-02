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
    }
}