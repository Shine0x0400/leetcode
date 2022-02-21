package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/2
 */
class JZ53_AppearCountInSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        val lower = binarySearch(nums, 0, nums.lastIndex, target, true)
        val upper = binarySearch(nums, 0, nums.lastIndex, target, false)
        return if (lower != -1) upper - lower + 1 else 0
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int, isLower: Boolean): Int {
        var left = start
        var right = end
        var ans = -1

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                ans = mid

                if (isLower) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }

        return ans
    }
}