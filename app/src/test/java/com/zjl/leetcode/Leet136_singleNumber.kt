package com.zjl.leetcode

/**
 *
 *
 * @author zjl
 * @date  2022/3/24
 */
class Leet136_singleNumber {

    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        nums.forEach {
            ans = ans xor it
        }
        return ans
    }
}