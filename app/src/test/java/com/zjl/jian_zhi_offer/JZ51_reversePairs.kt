package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/2
 */
class JZ51_reversePairs {

    /**
     * 分治，使用归并排序
     * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
     */
    fun reversePairs(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }

        return reversePairs(nums, 0, nums.lastIndex, IntArray(nums.size))
    }

    private fun reversePairs(nums: IntArray, left: Int, right: Int, temp: IntArray): Int {
        if (left == right) {
            return 0
        }

        val mid = left + (right - left) / 2 // avoid overflow
        val leftPairs = reversePairs(nums, left, mid, temp)
        val rightPairs = reversePairs(nums, mid + 1, right, temp)
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs
        }

        val crossPairs = merge(nums, left, mid, right, temp)
        return leftPairs + rightPairs + crossPairs
    }

    private fun merge(nums: IntArray, left: Int, mid: Int, right: Int, temp: IntArray): Int {
        for (i in left..right) {
            temp[i] = nums[i]
        }
        var count = 0
        var i = left
        var j = mid + 1
        for (k in left..right) {
            if (i > mid) {
                nums[k] = temp[j]
                j++
            } else if (j > right) {
                nums[k] = temp[i]
                i++
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i]
                i++
            } else {
                nums[k] = temp[j]
                j++
                count += mid - i + 1 // 左半边剩余的所有元素，与j处元素，都可以组成逆序对
            }
        }

        return count
    }

//    // Brute Force
//    fun reversePairs(nums: IntArray): Int {
//        var count = 0
//        for (i in nums.lastIndex - 1 downTo 0) {
//            val cur = nums[i]
//            for (j in i + 1..nums.lastIndex) {
//                if (cur > nums[j]) {
//                    count++
//                }
//            }
//        }
//        return count
//    }
}