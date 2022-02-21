package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/2/21
 */
class JZ42_MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        var j = 0
        var max = nums[0]

        var t = 0
        while (j < nums.size) {
            t += nums[j++]
            if (t > max) {
                max = t
            }

            if (t <= 0) {
                t = 0
            }
        }

        return max
    }
}