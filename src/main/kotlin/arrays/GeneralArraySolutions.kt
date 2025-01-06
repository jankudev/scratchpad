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
         *
         * Constraints/rules/hints
         * - there is always such element present
         */
        fun majorityElement(nums: IntArray): Int {
            var possibleMajorityNum = nums[0]
            var count = 0

            for (num in nums) {
                if (count == 0) {
                    possibleMajorityNum = num
                }
                count += if (num == possibleMajorityNum) 1 else -1
            }

            return possibleMajorityNum
        }

        /**
         * Rotate array to the right by k-places in-place
         */
        fun rotate(nums: IntArray, k: Int): Unit {
            val moveRightBy = k % nums.size
            val newArray = nums.takeLast(moveRightBy).plus(nums.take(nums.size - moveRightBy))
            for (i in nums.indices) {
                nums[i] = newArray[i]
            }
        }

        /**
         * Choose the maximum possible profit as a difference between 2 prices in order (1st buy, 2nd sell)
         * @param prices list of prices
         * @return the maximum possible difference or 0 if no profit can be made
         */
        fun maxProfit(prices: IntArray): Int {
            var bestBuyPrice = Int.MAX_VALUE
            var maxProfit = 0

            for (price in prices) {
                if (price < bestBuyPrice) {
                    bestBuyPrice = price
                }
                val profit = price - bestBuyPrice
                if (profit > maxProfit) {
                    maxProfit = profit
                }
            }
            return maxProfit
        }

        /**
         * Given a sequence of prices of a single stock with the limitation of holding max 1 stock at a time,
         * count the maximum potential profit.
         * hint: we can sum all the positive differences between the consecutive prices (longer sequence is accumulation)
         * @param sequence of prices of stock
         * @return the maximum potential profit
         */
        fun maxProfit2(prices: IntArray): Int {
            var totalProfit = 0
            for (i in 0 until prices.size - 1) {
                if (prices[i] < prices[i + 1]) {
                    totalProfit += prices[i + 1] - prices[i]
                }
            }
            return totalProfit
        }

        fun maxProfit2_functional(prices: IntArray): Int {
            return prices.dropLast(1)
                .mapIndexed { index, price -> price to prices[index+1] }
                .filter { (price, nextPrice) -> price < nextPrice }
                .sumBy { (price, nextPrice) -> nextPrice - price }
        }

    }
}