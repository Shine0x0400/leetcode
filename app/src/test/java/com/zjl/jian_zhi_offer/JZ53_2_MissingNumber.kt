package com.zjl.jian_zhi_offer

/**
 *
 *
 * @author dylannzhang
 * @date 2022/3/3
 */
class JZ53_2_MissingNumber {
    /**
     * 题解写法
     */
    fun missingNumber(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid == nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1 // note
            }
        }

        // now left > right
        return left
    }

//    fun missingNumber(nums: IntArray): Int {
//        var left = 0
//        var right = nums.lastIndex
//        if (right == nums.last()) {
//            return right + 1
//        }
//
//        while (left < right) {
//            val mid = left + (right - left) / 2
//            if (mid == nums[mid]) {
//                left = mid + 1
//            } else {
//                right = mid
//            }
//        }
//
//        // now left == right
//        return left
//    }
}