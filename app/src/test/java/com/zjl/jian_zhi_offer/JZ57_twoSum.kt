package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/4
 */
class JZ57_twoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var i = 0
        var j = nums.lastIndex
        while (i < j) {
            val sum = nums[i] + nums[j]
            if (sum < target) {
                i++
            } else if (sum > target) {
                j--
            } else {
                return intArrayOf(nums[i], nums[j])
            }
        }
        return IntArray(2)
    }
}